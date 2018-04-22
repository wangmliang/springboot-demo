package com.wml.springboot.controller;

import com.wml.springboot.config.RedisConfig;
import com.wml.springboot.entity.User;
import com.wml.springboot.services.UserService;
import com.wml.springboot.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangml on 2018/4/20.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RedisService<User> redisService;

    @Autowired
    private UserService userService;
    
    /**
     * 测试提交
     */
    public void test() {

    }
    @RequestMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    //@ResponseBody
    public User findAllUser(@PathVariable("id") Integer id) throws Exception {
        System.out.println("redis开始存储...");
        redisService.set("userId", id.toString());
        System.out.println("redis开始取值...");
        System.out.println("value:" + redisService.get("userId"));
        if(true) {
            throw new Exception("发生错误");
        }
        return userService.findAllUser(id);
    }
}
