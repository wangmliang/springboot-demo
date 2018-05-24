package com.wml.springboot.im.service;

import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.mapper.StaffDao;
import com.wml.springboot.im.entity.ImGroup;
import com.wml.springboot.im.mapper.ImGroupMapper;
import com.wml.springboot.im.packet.ContextUser;
import com.wml.springboot.im.packet.LayimContextUserInfo;
import com.wml.springboot.util.StaffUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private ImGroupMapper imGroupMapper;

    @Autowired
    private StaffDao staffDao;

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
                    groupMap.put("sign", "在深邃的编码世界，做一枚轻盈的纸飞机");
                    groupMap.put("avatar", "a.jpg");
                    groupMap.put("status", "online");
                    groupMapList.add(groupMap);
                });
                imGroup.setList(groupMapList);
            }
        });
        Map<String, Object> groupMap = new HashMap<>();
        groupMap.put("id", userId);
        groupMap.put("username", staff.getRealName());
        groupMap.put("sign", "在深邃的编码世界，做一枚轻盈的纸飞机");
        groupMap.put("avatar", "a.jpg");
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
            contextUser.setAvatar("a.jpg");
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
}
