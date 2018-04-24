package com.wml.springboot.mapper;

import com.wml.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 普通Mapper接口实例
 * <pre>
 * <b>Title：</b>UsersRepository.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 11:32<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAll();
}