package com.wml.springboot.util;

import com.wml.springboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 * <pre>
 * <b>Title：</b>ShiroUtils.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2017年8月22日 - 上午9:13:34<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2017 ASPire Tech.</b>
 * </pre>
 */
public class ShiroUtil {

    /**
     * 得到当前的session
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:15:20
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 得到当前的session
     * @param flag
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:15:15
     */
    public static Session getSession(boolean flag) {
        return SecurityUtils.getSubject().getSession(flag);
    }

    /**
     * 得到当前subject
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:15:10
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 得到当前的ShiroUser
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:15:03
     */
    public static User getCurrentUser() {
        return (User)SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 得到当前的用户id
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:14:32
     */
    public static Integer getUserId() {
        return getCurrentUser().getUserId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static void removeSessionAttribute(Object key) {
        getSession().removeAttribute(key);
    }

    /**
     * 是否登录
     * @return
     * @author WML
     * 2017年8月22日 - 上午9:21:23
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 退出登录
     * @author WML
     * 2017年8月22日 - 上午9:21:06
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获得当前session验证码 并且删除
     * @param key session中验证码的key值
     * @return 返回value 并且删除key
     * @author WML
     * 2017年8月22日 - 上午9:14:40
     */
    public static String getSessionCaptcha(String key) {
        String captcha = getSessionAttribute(key).toString();
        getSession().removeAttribute(key);
        return captcha;
    }

}
