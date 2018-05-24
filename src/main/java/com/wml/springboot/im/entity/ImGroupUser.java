package com.wml.springboot.im.entity;

/**
 * <pre>
 * <b>Title：</b>ImGroupUser.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 11:30<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class ImGroupUser {
    private Long id;
    private Long groupId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

