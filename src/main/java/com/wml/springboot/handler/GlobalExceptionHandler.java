package com.wml.springboot.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 全局监听系统500错误，响应对应错误信息
 * <pre>
 * <b>Title：</b>TestController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/23 - 10:57<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String DEFAULT_404_ERROR_VIEW = "404";

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    @ExceptionHandler(value = Exception.class)
    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)*/
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        String viewName = DEFAULT_ERROR_VIEW;
        HttpStatus status = getStatus(req);
        if (status.value() == 404){
            viewName = DEFAULT_404_ERROR_VIEW;
        } else {
            mav.addObject("exception", pringExceptionInfo(e));
            logger.error("系统500Error： 请求链接：{}，错误信息：{}", req.getRequestURL(), e.getMessage());
        }
        mav.addObject("url", req.getRequestURL());
        // 设定状态为成功，避免浏览器提示错误
        mav.setStatus(HttpStatus.OK);
        mav.setViewName(viewName);
        return mav;
    }

    /**
     *
     * @param e
     * @return
     */
    private static String pringExceptionInfo(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
