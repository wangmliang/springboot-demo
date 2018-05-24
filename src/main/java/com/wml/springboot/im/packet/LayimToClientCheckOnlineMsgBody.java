package com.wml.springboot.im.packet;

import com.wml.springboot.im.common.intf.LayimMsgType;

public class LayimToClientCheckOnlineMsgBody extends LayimBaseBody {

    public LayimToClientCheckOnlineMsgBody(boolean online){
        this.online = online;
    }


    public boolean isOnline() {
        return online;
    }

    private boolean online;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    @Override
    public byte getMtype() {
        return LayimMsgType.CLIENT_CHECK_ONLINE;
    }
}
