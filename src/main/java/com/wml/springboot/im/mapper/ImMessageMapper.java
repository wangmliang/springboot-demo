package com.wml.springboot.im.mapper;

import com.wml.springboot.im.entity.ImGroup;
import com.wml.springboot.im.entity.ImMessage;
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
public interface ImMessageMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ImMessage record);

    int insertSelective(ImMessage record);

    ImMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImMessage record);

    int updateByPrimaryKey(ImMessage record);

    /**
     * 查询未读消息数
     * @param uid
     * @return
     */
    int getImMessageCount(Long uid);

    /**
     * 更新消息为已读
     * @param uid
     * @return
     */
    int updateMessageIsRead(Long uid);

    /**
     * 根据用户查询消息列表
     * @param uid
     * @return
     */
    List<ImMessage> getMessageByUid(Long uid);
}
