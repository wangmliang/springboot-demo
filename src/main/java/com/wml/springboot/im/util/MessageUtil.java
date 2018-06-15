package com.wml.springboot.im.util;

import com.xiaoleilu.hutool.json.JSONUtil;
import org.apache.commons.validator.Msg;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;
import org.tio.server.ServerGroupContext;
import org.tio.utils.lock.SetWithLock;
import org.tio.websocket.common.WsResponse;

import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <pre>
 * <b>Title：</b>MessageUtil.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/6/15 - 17:56<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class MessageUtil {

    /**
     * 给MsgUtil hold住实例，直接调用
     */
    public static ServerGroupContext groupContext;

    public static boolean existsUser(String userId) {
        SetWithLock<ChannelContext> set = Aio.getChannelContextsByUserid(groupContext, userId);
        if(set == null || set.size() < 1) {
            return false;
        }
        return true;
    }

    /**
     * 发送到指定用户
     * @param userId
     * @param message
     */
    public static void sendToUser(String userId, Msg message) {
        SetWithLock<ChannelContext> toChannleContexts = Aio.getChannelContextsByUserid(groupContext, userId);
        if(toChannleContexts == null || toChannleContexts.size() < 1) {
            return;
        }
        ReentrantReadWriteLock.ReadLock readLock = toChannleContexts.getLock().readLock();
        readLock.lock();
        try{
            Set<ChannelContext> channels = toChannleContexts.getObj();
            for(ChannelContext channelContext : channels){
                send(channelContext, message);
            }
        }finally{
            readLock.unlock();
        }
    }

    /**
     * 功能描述：[发送到群组(所有不同协议端)]
     * @param group
     * @param msg
     */
    public static void sendToGroup(String group, Msg msg){
        if(msg == null) {
            return;
        }
        SetWithLock<ChannelContext> withLockChannels = Aio.getChannelContextsByGroup(groupContext, group);
        if(withLockChannels == null) {
            return;
        }
        ReentrantReadWriteLock.ReadLock readLock = withLockChannels.getLock().readLock();
        readLock.lock();
        try{
            Set<ChannelContext> channels = withLockChannels.getObj();
            if(channels != null && channels.size() > 0){
                for(ChannelContext channelContext : channels){
                    send(channelContext,msg);
                }
            }
        }finally{
            readLock.unlock();
        }
    }

    /**
     * 发送到指定通道;
     * @param channelContext
     * @param msg
     */
    public static void send(ChannelContext channelContext,Msg msg){
        if(channelContext == null) {
            return;
        }
        WsResponse response = WsResponse.fromText(JSONUtil.toJsonStr(msg), "utf-8");
        Aio.sendToId(channelContext.getGroupContext(), channelContext.getId(), response);
    }
}
