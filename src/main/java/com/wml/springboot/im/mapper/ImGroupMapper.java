package com.wml.springboot.im.mapper;

import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.im.entity.ImGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <b>Title：</b>ImGroupMapper.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 11:45<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public interface ImGroupMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImGroup record);

    int insertSelective(ImGroup record);

    ImGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImGroup record);

    int updateByPrimaryKey(ImGroup record);

    /**
     * 查询用户分组
     * @param userId
     * @return
     */
    List<ImGroup> getImGroupByUserIdAndType(@Param("userId") Long userId, @Param("type") Integer type);

    /**
     * 查找页查询群组列表
     * @param map
     * @return
     */
    List<ImGroup> getImGroupByGroupName(Map<String, Object> map);
}
