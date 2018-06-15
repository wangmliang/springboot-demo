package com.wml.springboot.im.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.mapper.StaffDao;
import com.wml.springboot.im.common.util.SpringUtil;
import com.wml.springboot.im.entity.ImGroup;
import com.wml.springboot.im.entity.ImMessage;
import com.wml.springboot.im.mapper.ImGroupMapper;
import com.wml.springboot.im.mapper.ImMessageMapper;
import com.wml.springboot.im.packet.ContextUser;
import com.wml.springboot.im.packet.LayimContextUserInfo;
import com.wml.springboot.im.packet.LayimToClientNoticeMsgBody;
import com.wml.springboot.im.packet.convert.BodyConvert;
import com.wml.springboot.im.server.LayimWebsocketStarter;
import com.wml.springboot.im.util.MessageUtil;
import com.wml.springboot.util.DateUtil;
import com.wml.springboot.util.StaffUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;
import org.tio.server.ServerGroupContext;
import org.tio.utils.lock.SetWithLock;
import org.tio.websocket.common.WsResponse;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 * <b>Title：</b>ImService.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 12:09<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Service("imService")
@Transactional
public class ImService {

    private Logger logger = LoggerFactory.getLogger(ImService.class);

    @Autowired
    private ImGroupMapper imGroupMapper;

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private ImMessageMapper imMessageMapper;

    /**
     * Im初始化
     * @return
     */
    public Map<String, Object> imInit() {
        Map<String, Object> map = new HashMap<>();
        Staff staff = StaffUtil.getLoginStaff();
        Long userId = staff.getStaffId();
        List<ImGroup> imGroupList = imGroupMapper.getImGroupByUserIdAndType(userId, 0);
        imGroupList.forEach(imGroup -> {
            List<Map<String, Object>> groupMapList = new ArrayList<>();
            List<Staff> staffList = imGroup.getUserList();
            if(!staffList.isEmpty()) {
                staffList.forEach(s -> {
                    Map<String, Object> groupMap = new HashMap<>();
                    groupMap.put("id", s.getStaffId());
                    groupMap.put("username", s.getRealName());
                    groupMap.put("sign", s.getSign());
                    groupMap.put("avatar", s.getAvatar());
                    groupMap.put("status", "online");
                    groupMapList.add(groupMap);
                });
                imGroup.setList(groupMapList);
            }
        });
        Map<String, Object> groupMap = new HashMap<>();
        groupMap.put("id", userId);
        groupMap.put("username", staff.getRealName());
        groupMap.put("sign", staff.getSign());
        groupMap.put("avatar", staff.getAvatar());
        groupMap.put("status", "online");
        map.put("mine", groupMap);      // 基本信息
        map.put("friend", imGroupList);    // 好友列表
        map.put("group", imGroupMapper.getImGroupByUserIdAndType(userId, 1));     // 群组列表
        return map;
    }

    @Transactional
    public LayimContextUserInfo getContextUserInfo(Long userId){
        LayimContextUserInfo contextUserInfo = new LayimContextUserInfo();
        ContextUser contextUser = new ContextUser();
        Staff user = staffDao.findStaff(userId);

        if(user != null) {
            contextUser.setUserid(userId.toString());
            contextUser.setUsername(user.getRealName());
            contextUser.setAvatar(user.getAvatar());
            contextUserInfo.setContextUser(contextUser);
            List<ImGroup> imGroupList = imGroupMapper.getImGroupByUserIdAndType(userId, 1);
            if(!imGroupList.isEmpty()) {
                //jdk 1.8 lambda 表达式
                List<String> groupIds = imGroupList.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
                contextUserInfo.setGroupIds(groupIds);
            }
            return contextUserInfo;
        }
        return null;
    }

    /**
     * 获取当前用户的所有好友
     * */
    @Transactional
    public  List<String> getAllFriends(long userId){
        List<ImGroup> imGroupList = imGroupMapper.getImGroupByUserIdAndType(userId, 0);
        List<String> userIds = new ArrayList<>();
        imGroupList.forEach(group->
                userIds.addAll(group.getUserList()
                        .stream()
                        .map(user -> user.getStaffId().toString())
                        .collect(Collectors.toList())));
        return userIds;
    }

    /**
     * im查询用户列表
     * @param value
     * @return
     */
    public PageInfo<Staff> getStaffByIm(String value, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<Staff>(staffDao.getStaffByIm(value));
    }

    /**
     * im查询群组信息
     * @param value
     * @return
     */
    public PageInfo<ImGroup> getGroupByIm(String value, Integer pageNumber, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", StaffUtil.getLoginStaffId());
        map.put("groupName", value);
        // 分页
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<ImGroup>(imGroupMapper.getImGroupByGroupName(map));
    }

    /**
     * 添加申请消息
     * @param uid
     * @param group
     * @param remarks
     */
    public void apply(String uid, String group, String remarks) {
        ImMessage message = new ImMessage();
        ImGroup imGroup = null;
        Long toId = null;
        if(StringUtils.isNotBlank(group)) {
            message.setContent("申请添加你为好友");
            message.setUid(Long.valueOf(uid));  // 接受消息用户id
            message.setFrom_group(Long.valueOf(group));     // 申请群组id
            toId = Long.valueOf(uid);
        } else {
            imGroup = getImGroupById(Long.valueOf(uid));
            message.setContent("申请加入群组【" + imGroup.getGroupname() + "】");
            message.setUid(imGroup.getUserId()); // 群主用户id
            message.setFrom_group(Long.valueOf(uid));     // 申请群组id
            toId = imGroup.getUserId();
        }
        message.setFrom(StaffUtil.getLoginStaffId());   // 申请人
        message.setRemark(remarks);
        message.setRead("0"); // 默认未读
        message.setType(StringUtils.isBlank(group) ? "2" : "1"); // 群组为null标识好友申请
        message.setTime(DateUtil.getCurDateTime());
        imMessageMapper.insert(message);

        // 推送消息,页面消息增加闪动提示
        pushApplyMessage(toId.toString());
    }

    /**
     * 获取channelContext
     * */
    private static Set<ChannelContext> getChannelContext(String toId) {
        ServerGroupContext context = MessageUtil.groupContext;
        //找到用户
        SetWithLock<ChannelContext> channelContext = context.users.find(context, toId);
        return channelContext.getObj();
    }

    /**channelContext
     * 服务端主动推送消息
     * */
    public void pushApplyMessage(String toId) {
        LayimToClientNoticeMsgBody body = new LayimToClientNoticeMsgBody();
        Set<ChannelContext> channels = getChannelContext(toId);
        if(channels != null && channels.size() > 0){
            for(ChannelContext channelContext : channels){
                //先判断是否在线，再去查询数据库，减少查询次数
                if (channelContext != null && !channelContext.isClosed()) {
                    int count = imMessageMapper.getImMessageCount(Long.valueOf(toId));
                    body.setCount(count);
                    push(channelContext, body);
                }
            }
        }
    }
    /**
     * 服务端主动推送消息
     * */
    private void push(ChannelContext channelContext,Object msg) {
        try {
            WsResponse response = BodyConvert.getInstance().convertToTextResponse(msg);
            Aio.send(channelContext, response);
        }catch (IOException ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * 获取群组信息
     * @param id
     * @return
     */
    public ImGroup getImGroupById(Long id) {
        return imGroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新消息为已读
     */
    public void readMessage() {
        imMessageMapper.updateMessageIsRead(StaffUtil.getLoginStaffId());
    }

    /**
     * 根据id获取消息列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageInfo<ImMessage> getMessageByuid(Integer pageNumber, Integer pageSize) {
        if(pageNumber == 1) {
            pageNumber = 0;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<ImMessage>(imMessageMapper.getMessageByUid(StaffUtil.getLoginStaffId()));
    }

}
