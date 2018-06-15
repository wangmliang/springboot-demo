package com.wml.springboot.im.entity;

import com.wml.springboot.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * layim 消息对象
 * <pre>
 * <b>Title：</b>ImMessage.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/6/15 - 15:35<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class ImMessage {
    private Long id;
    // '消息类型(1、好友申请 2、群组申请 3、拒绝好友申请  4、拒绝群组申请)',
    private String type;
    // 用户id
    private Long uid;
    // 请求用户id
    private Long from;
    // 加入群组id
    private Long from_group;
    // 展示信息
    private String content;
    // 备注信息
    private String remark;
    // 是否已读(0:未读  1:已读)
    private String read;
    // 时间
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getFrom_group() {
        return from_group;
    }

    public void setFrom_group(Long from_group) {
        this.from_group = from_group;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getTime() {
        /**
         * 规则：5分钟内显示刚刚
         * 一天内显示X小时前
         * 超出一天显示X天前
         */
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date smdate = sdf.parse(sdf.format(time));
            Date bdate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            //long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            // 获得两个时间的毫秒时间差异
            long diff = time2 - time1;
            // 计算差多少天
            long day = diff / nd;
            // 计算差多少小时
            long hour = diff % nd / nh;
            // 计算差多少分钟
            long min = diff % nd % nh / nm;
            // 计算差多少秒//输出结果
            // long sec = diff % nd % nh % nm / ns;
            //return day + "天" + hour + "小时" + min + "分钟";
            if(min <= 5) {
                return "刚刚";
            } else if(min < 60) {
                return min + "分钟前";
            } else if(hour >= 1) {
                return hour + "小时前";
            } else if(hour >= 24) {
                return day + "天前";
            } else if(hour >= 720) {
                return (hour % 720) + "个月前";
            }
            return "很久以前";
        } catch (Exception e) {
            return "未知时间";
        }

    }

    public void setTime(String time) {
        this.time = time;
    }
}
