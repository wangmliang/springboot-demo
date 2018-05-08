package com.wml.springboot.auth;

import com.wml.springboot.util.DateUtil;
import com.wml.springboot.util.StringTools;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <b>Title：</b>BaseController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/8 - 17:44<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class BaseController {
    protected static final String UTF8 = "UTF-8";

    /*protected Map<String, Object> page(List<?> dataPage)
    {
        Map<String, Object> modelMap = new HashMap(3);

        modelMap.put("records", Integer.valueOf(dataPage.size()));
        modelMap.put("rows", dataPage);
        modelMap.put("page", 1);
        modelMap.put("total", 1);
        modelMap.put("success", Boolean.valueOf(true));

        return modelMap;
    }*/

    protected <T> Map<String, Object> success(T data)
    {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("data", data);
        modelMap.put("success", Boolean.valueOf(true));
        return modelMap;
    }

    protected Map<String, Object> fail(String message)
    {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("message", message);
        modelMap.put("success", Boolean.valueOf(false));
        return modelMap;
    }

    protected void fail(HttpServletResponse response, String message)
            throws IOException
    {
        outputString(response, JSONObject.fromObject(fail(message)).toString());
    }

    protected <T> void success(HttpServletResponse response, T message)
            throws IOException
    {
        outputString(response, JSONObject.fromObject(success(message)).toString());
    }

    protected void output(HttpServletResponse response, String contentType, String characterEncoding, String obj) throws IOException
    {
        disableCache(response);
        response.setContentType(contentType);
        response.setCharacterEncoding(characterEncoding);
        response.getWriter().write(obj);
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void disableCache(HttpServletResponse response)
    {
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0L);
        response.setHeader("Cache-Control", "no-cache");
    }

    protected void outputMatch(HttpServletRequest request, HttpServletResponse response, String obj)
            throws IOException
    {
        String requested = request.getHeader("x-requested-with");
        if (StringTools.isEmptyString(requested)) {
            requested = request.getHeader("X-Requested-With");
        }
        if ((null != requested) && (requested.equalsIgnoreCase("XMLHttpRequest")))
        {
            output(response, "application/json", "UTF-8", obj);
        }
        else
        {
            String rtnName = request.getParameter("rtnName");
            if (isNotEmpty(rtnName)) {
                outputJS(request, response, "var " + rtnName + "=" + obj);
            } else {
                output(response, "text/html", "UTF-8", obj);
            }
        }
    }

    protected void outputString(HttpServletResponse response, String obj)
            throws IOException
    {
        output(response, "text/html", "UTF-8", obj);
    }

    protected void outputJSON(HttpServletRequest request, HttpServletResponse response, String msg)
            throws IOException
    {
        output(response, "application/json", "UTF-8", msg);
    }

    protected void outputJS(HttpServletRequest request, HttpServletResponse response, String msg)
            throws IOException
    {
        output(response, "application/javascript", "UTF-8", msg);
    }

    protected Map<String, Object> fail(String code, String message)
    {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("code", code);
        modelMap.put("message", message);
        modelMap.put("success", Boolean.valueOf(false));
        return modelMap;
    }

    protected HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpSession getSession()
    {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (sra != null) {
            return sra.getRequest().getSession();
        }
        return null;
    }

    protected boolean isEmpty(String value)
    {
        return (value == null) || ("".equals(value.trim()));
    }

    protected boolean isEmpty(Long value)
    {
        return value == null;
    }

    protected boolean isNotEmpty(String value)
    {
        return (value != null) && (!"".equals(value.trim()));
    }

    protected boolean isNotEmpty(Long value)
    {
        return value != null;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(String.class, new PropertyEditorSupport()
        {
            public void setAsText(String text)
            {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            public String getAsText()
            {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            public void setAsText(String text)
            {
                if (BaseController.this.isNotEmpty(text)) {
                    if (text.length() == 10) {
                        setValue(DateUtil.getDate(text, "yyyy-MM-dd"));
                    } else if (text.length() == 19) {
                        setValue(DateUtil.getDate(text, "yyyy-MM-dd HH:mm:ss"));
                    }
                }
            }
        });
    }
}
