package com.wml.springboot.im.entity;

import com.wml.springboot.auth.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <b>Title：</b>ImGroup.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 11:29<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class ImGroup {
    private Long id;
    private String groupname;
    private Long userId;
    private Integer type;
    private String avatar;

    private List<Staff> userList;

    private List<Map<String, Object>> list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Staff> getUserList() {
        return userList;
    }

    public void setUserList(List<Staff> userList) {
        this.userList = userList;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
