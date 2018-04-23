package com.wml.springboot.controller;

import com.wml.springboot.entity.UserJpa;
import com.wml.springboot.mapper.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Data-Jpa操作实例
 * <pre>
 * <b>Title：</b>UsersController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 11:34<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@RestController
@RequestMapping(value = "/userJpa")
public class UserJpaController {

    private Logger logger = LoggerFactory.getLogger(UserJpaController.class);
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/test")
    @ResponseBody
    @Transactional  // 事物回滚测试
    // @Transactional(noRollbackFor = {Exception.class}) // 事物不回滚测试
    public Boolean test() {
        usersRepository.save(new UserJpa("aaa", 18));
        usersRepository.save(new UserJpa("bbb", 19));
        usersRepository.save(new UserJpa("ccc", 20));
        usersRepository.save(new UserJpa("ddd", 21));
        usersRepository.save(new UserJpa("eee", 22));
        int i= 5 / 0;
        logger.info("集合长度：{}", usersRepository.findAll().size());
        // 测试findUser, 查询姓名为FFF的User
        logger.info("aaa得年龄：{}", usersRepository.findUser("aaa").getAge().longValue());
        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        logger.info("bbb得姓名：{}", usersRepository.findByNameAndAge("bbb", 19).getName());
        // 测试删除姓名为AAA的User
        usersRepository.delete(usersRepository.findByName("ccc"));
        return Boolean.TRUE;
    }
}
