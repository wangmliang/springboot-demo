package com.wml.springboot.handler;

import com.wml.springboot.exception.ErrorInfo;
import com.wml.springboot.exception.MyException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

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

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String DEFAULT_404_ERROR_VIEW = "404";

    /**
     * 获取请求错误状态码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    /**
     * 系统默认错误处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        String viewName = DEFAULT_ERROR_VIEW;
        HttpStatus status = getStatus(req);
        if (status.value() == 404){
            viewName = DEFAULT_404_ERROR_VIEW;
        } else {
            mav.addObject("exception", pringExceptionInfo(e));
            logger.error("系统500Error： 请求链接：{}，错误信息：{}", req.getRequestURL(), e.getMessage());
            System.err.println(pringExceptionInfo(e));
        }
        mav.addObject("url", req.getRequestURI());
        // 设定状态为成功，避免浏览器提示错误
        mav.setStatus(HttpStatus.OK);
        mav.setViewName(viewName);
        return mav;
    }

    /**
     * 自定义异常错误返回
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo myErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo error = new ErrorInfo();
        HttpStatus status = getStatus(req);
        error.setError(status.value() == 404 ? "Not Found" : "500 Error");
        error.setStatus(status.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(new Date().getTime());
        error.setPath(req.getRequestURI());
        return error;
    }

    /**
     * 无权限错误拦截
     * @param req
     * @param response
     * @param e
     * @throws Exception
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public void unauthorizedErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) throws Exception {
        response.sendRedirect("/403");
        return;
    }
    /**
     * 异常信息以字符串输出
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
