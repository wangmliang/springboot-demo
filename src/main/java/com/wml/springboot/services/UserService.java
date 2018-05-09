package com.wml.springboot.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wml.springboot.entity.User;
import com.wml.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.io.IOException;
import java.util.List;

/**
 * 普通Service实例
 * <pre>
 * <b>Title：</b>UsersRepository.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 11:32<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Service
public class UserService {

    //User findAllUser(Integer id);

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public User findAllUser(Integer id) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        return userMapper.selectByPrimaryKey(id);
    };

    @Transactional  // 事物回滚测试
    //@Transactional(noRollbackFor = {Exception.class}) // 事物不回滚测试
    public int insert(User record) {
        entryptPassword(record);
        return userMapper.insert(record);
    }

    /**
     * 用户密码加密
     * @param user
     */
    public static void entryptPassword(User user)
    {
        byte[] salt = Digests.generateSalt(8);
        user.setSalt(Encodes.encodeHex(salt));
        byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, 1024);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    /**
     *
     * @param password
     * @param salt
     * @return
     */
    public static String entryptPassword(String password, String salt)
    {
        byte[] hashPassword = Digests.sha1(password.getBytes(), salt.getBytes(), 1024);
        return Encodes.encodeHex(hashPassword);
    }
    public static void main( String[] args ) throws IOException {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        entryptPassword(user);
        System.out.println(user.toString());
        entryptPassword("123456", user.getSalt());
        System.out.println(user.toString());
    }

    public PageInfo<User> getAll(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<User>(userMapper.getAll());
    }

    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

}
