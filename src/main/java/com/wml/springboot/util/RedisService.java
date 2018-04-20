package com.wml.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangml on 2018/4/20.
 */
@Service
public class RedisService<T> {

    Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 一天有多少分钟，默认时间是一天
     */
    private static final long MINUTES_OF_ONE_DAY = 24 * 60;

    /**
     * 判断 key 是否在 redis 数据库中
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public String get(String key) {
        try {
            return (String)redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            logger.error("redis获取key=[{}]值失败",key,e);
            return  null;
        }
    }

    /**
     * 删除 key 对应的 value
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // 复制
    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        }catch (Exception e){
            logger.error("redis插入值key=[{}],value=[{}]时出错",key,value,e);
            return  false;
        }
        return true;
    }

    public void remove(String key) {
        try {
            this.delete(key);
        }catch (Exception e){
            logger.error("redis删除key=[{}]，失败",key,e);
        }

    }

    public boolean set(String key, String value, int timeout) {
        try {
            redisTemplate.opsForValue().set(key,value,timeout, TimeUnit.SECONDS);
        }catch (Exception e){
            logger.error("redis插入值key=[{}],value=[{}],过期时间timeout=[{}]秒时出错", key, value, timeout, e);
            return false;
        }
        return true;
    }

    public int size() {
        try {
            Long dbSize = (Long) redisTemplate.execute(new RedisCallback() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.dbSize();
                }
            });
            return dbSize.intValue();
        }catch (Exception e){
            logger.error("获取集群库中存储个数失败,返回默认值0",e);
            return  0;
        }
    }

    public Map<String, String> getMulti(Collection<String> keys) {
        Map<String,String> map = new HashMap<String, String>();
        if (keys==null||keys.size()==0){
            return  map;
        }
        try {
            List<String> valueList = redisTemplate.opsForValue().multiGet(keys);
            List<String> keyList = (List<String>)keys;
            String key = null;
            String value = null;
            if (valueList != null && valueList.size() > 0){
                for (int i=0;i<valueList.size();i++){
                    key = keyList.get(i);
                    value = valueList.get(i);
                    map.put(key,value);
                }
            }
        }catch (Exception e){
            logger.error("批量获取redis值失败,keys=[{}]",keys,e);
        }finally {
            return  map;
        }
    }

    public void clear() {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return null;
            }
        });
    }

    public long incr(String key, int incrBy) {
        try {
            return redisTemplate.opsForValue().increment(key,incrBy);
        }catch (Exception e){
            logger.error("redis key=[{}],incrBy=[{}]自增长失败,将返回0",key,incrBy,e);
            return 0l;
        }
    }

    public long incrExpir(final String key, final int incrBy, final int timeOut) {
        Long incrResult = 0l;
        try {
            List<Object> list = redisTemplate.executePipelined(new RedisCallback<List<Object>>() {
                @Override
                public List<Object> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    redisConnection.incrBy(key.getBytes(), incrBy);
                    redisConnection.expire(key.getBytes(), timeOut);
                    return null;
                }
            });
            if (list!=null&&list.size()>0){
                incrResult = (Long) list.get(0);
            }
        }catch (Exception e){
            logger.error("redis key=[{}],decrBy=[{}],timeout=[{}]自增失败，将返回0",key,incrBy,timeOut,e);
        }
        return incrResult;
    }

    public void mutiIncrExpir(final List<List<Object>> incrs) {
        try {
            redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    for (List<Object> objects : incrs) {
                        String key = (String) objects.get(0);
                        Integer incrBy = (Integer) objects.get(1);
//                        Integer timeOut = (Integer) objects.get(2);
                        redisConnection.incrBy(key.getBytes(), incrBy);
//                        redisConnection.expire(key.getBytes(),timeOut);
                    }
                    return true;
                }
            }, false, true);
        }catch (Exception e){
            logger.error("redis key=[{}],decrBy=[{}],timeout=[{}]自增失败",e);
        }
    }

    public long decr(final String key, final int decrBy) {
        try {
            return (Long)redisTemplate.execute(new RedisCallback() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.decrBy(key.getBytes(), decrBy);
                }
            });
        }catch (Exception e){
            logger.error("redis key=[{}],decrBy=[{}]自减少失败,将返回0",key,decrBy,e);
            return 0l;
        }
    }

    public void expirTime(String key, int timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public void expirAfter1970(final String key, final String value, final long timeout) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(key.getBytes(), value.getBytes());
                redisConnection.expireAt(key.getBytes(), timeout);
                return false;
            }
        }, false, true);
    }

    public void hincr(final String key,final Map<String,Integer> kvMap,final long expire){
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection conn) throws DataAccessException {
                for (String kv : kvMap.keySet()) {
                    conn.hIncrBy(key.getBytes(), kv.getBytes(), kvMap.get(kv).longValue());
                    if (expire > 0) conn.expire(kv.getBytes(), expire);
                }
                return false;
            }

        }, false, true);
    }

}
