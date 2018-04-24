package com.wml.springboot.services;

import com.wml.springboot.entity.User;
import com.wml.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Jdbc操作数据库实例
 * <pre>
 * <b>Title：</b>UserServiceImpl.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 10:49<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Service
@Transactional  // 事物回滚测试
//@Transactional(noRollbackFor = {Exception.class}) // 事物不回滚测试
public class UserServiceImpl implements UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserServiceImpl() {
        super();
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return jdbcTemplate.update("delete from t_user where user_id = ?", userId);
    }

    @Override
    public int insert(User record) {
        jdbcTemplate.update("insert into t_user(user_name, password, phone) values(?, ?, ?)", record.getUserName(), record.getPassword(), record.getPhone());
        int i = 5 /0 ;
        return 1;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return (User)jdbcTemplate.queryForObject("select * from t_user where user_id = ?", new Object[]{userId}, new BeanPropertyRowMapper(User.class));
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return jdbcTemplate.update("update t_user set phone = ? where user_id = ?", record.getPhone(), record.getUserId());
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
