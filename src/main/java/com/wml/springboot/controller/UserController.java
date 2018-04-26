package com.wml.springboot.controller;

import com.wml.springboot.entity.User;
import com.wml.springboot.services.UserService;
import com.wml.springboot.util.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 普通操作实例
 * <pre>
 * <b>Title：</b>JdbcController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 10:57<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisService<User> redisService;

    @Autowired
    private UserService userService;
    
    /**
     * 测试提交
     */
    public void test() {

    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User findAllUser(@PathVariable("id") Integer id) throws Exception {
        redisService.set("userId", id.toString());
        logger.info("redis取值:{}", redisService.get("userId"));

        User record = new User();
        record.setUserName("test_name");
        record.setPhone("15399999999");
        record.setPassword("666666");
        userService.insert(record);
        return userService.findAllUser(id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> getAll(int pageNumber, int pageSize) {
        return userService.getAll(pageNumber, pageSize).getList();
    }
}
