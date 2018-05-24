package com.wml.springboot.im.packet;

import com.wml.springboot.im.common.intf.LayimMsgType;

/**
 * 添加好友成功之后，需要推送给对方成功的消息
 * */
public class LayimToClientAddFriendMsgBody extends LayimBaseBody {
    @Override
    public byte getMtype() {
        return LayimMsgType.SERVER_TO_CLIENT_ADDFRIEND_NOTICE;
    }

    @Override
    public void setMtype(byte mtype) {

    }

    private String type;
    private String username;
    private String avatar;
    private Long groupid;
    private Long id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    private String sign;
}
