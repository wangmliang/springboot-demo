package com.wml.springboot.im.mapper;

import com.wml.springboot.im.entity.ImGroupUser;

/**
 * <pre>
 * <b>Title：</b>ImGroupMapper.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 11:45<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public interface ImGroupUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ImGroupUser record);

    int insertSelective(ImGroupUser record);

    ImGroupUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImGroupUser record);

    int updateByPrimaryKey(ImGroupUser record);
}
