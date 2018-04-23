package com.wml.springboot.controller;

import com.wml.springboot.entity.User;
import com.wml.springboot.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * jdbc操作数据库实例
 * <pre>
 * <b>Title：</b>JdbcController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 10:57<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@RestController
@RequestMapping(value = "/jdbc")
public class JdbcController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Integer id) {
        return userServiceImpl.selectByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Boolean insert() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("test123456");
        user.setPhone("12345678900");
        if(userServiceImpl.insert(user) == 1)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public Boolean update(@PathVariable("id") Integer id) {
        User user = userServiceImpl.selectByPrimaryKey(id);
        user.setPhone("11111111111");
        if(userServiceImpl.updateByPrimaryKey(user) == 1)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable("id") Integer id) {
        if(userServiceImpl.deleteByPrimaryKey(id) == 1)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
}
