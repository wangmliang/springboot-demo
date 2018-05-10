package com.wml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <pre>
 * <b>Title：</b>SpringContextHolder.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/10 - 11:58<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;
    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    public static ApplicationContext getApplicationContext()
    {
        assertContextInjected();
        return applicationContext;
    }

    public static String getRootRealPath()
    {
        String rootRealPath = "";
        try
        {
            rootRealPath = getApplicationContext().getResource("").getFile().getAbsolutePath();
        }
        catch (IOException e)
        {
            logger.warn("获取系统根目录失败");
        }
        return rootRealPath;
    }

    public static String getResourceRootRealPath()
    {
        String rootRealPath = "";
        try
        {
            rootRealPath = new DefaultResourceLoader().getResource("").getFile().getAbsolutePath();
        }
        catch (IOException e)
        {
            logger.warn("获取资源根目录失败");
        }
        return rootRealPath;
    }

    public static <T> Object getBean(String name)
    {
        assertContextInjected();
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType)
    {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    public static void clearHolder()
    {
        if (logger.isDebugEnabled()) {
            logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
    {
        if (applicationContext != null) {
            logger.info("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + applicationContext);
        }
        applicationContext = applicationContext;
    }

    private static void assertContextInjected()
    {
        if (null == applicationContext) {
            logger.error("applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
        }
    }
}
