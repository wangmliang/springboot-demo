package com.wml.springboot.controller;

import com.wml.springboot.config.RedisConfig;
import com.wml.springboot.config.TestConfig;
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

import static org.slf4j.LoggerFactory.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisService<User> redisService;

    @Autowired
    private UserService userService;

    @Autowired
    private TestConfig testConfig;

    /**
     * 
     * @param [id]
     * @return com.wml.springboot.entity.User
     * @author WML
     * @date 2018-04-22 - 下午 3:32
     */
    @RequestMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    //@ResponseBody
    public User findAllUser(@PathVariable("id") Integer id) throws Exception {
        System.out.println("redis开始存储...");
        redisService.set("userId", id.toString());
        System.out.println("redis开始取值...");
        System.out.println("value:" + redisService.get("userId"));

        LOG.info("设置logger-info信息....");
        LOG.debug("设置logger-debug信息....");
        LOG.warn("设置logger-warn信息....");
        LOG.error("设置logger-error信息....");
        System.out.println("测试获取配置文件参数：" + testConfig.toString());
        if(id == 2) {
            int i = 5 /0;
        }
        return userService.findAllUser(id);
    }

    @RequestMapping(value = "/json/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User toJson(@PathVariable("id") Integer id) throws Exception {
        return userService.findAllUser(id);
    }

}
