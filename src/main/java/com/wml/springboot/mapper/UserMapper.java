package com.wml.springboot.mapper;

import com.wml.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}