package com.wml.springboot.handler;

import com.sun.tools.internal.ws.processor.model.Model;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangml on 2018/4/20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String DEFAULT_404_ERROR_VIEW = "404";

    /*@ExceptionHandler(YourException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }
*/
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)*/
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        String viewName = DEFAULT_ERROR_VIEW;
        HttpStatus status = getStatus(req);
        System.out.println(" 错误状态码：" + status.value());
        if (status.value() == 404){
            viewName = DEFAULT_404_ERROR_VIEW;
        } else {
            mav.addObject("exception", pringExceptionInfo(e));
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
