package com.wml.springboot.services;

import com.github.pagehelper.PageHelper;
import com.wml.springboot.entity.User;
import com.wml.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * interface
 * Created by wangml on 2018/4/20.
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
}
