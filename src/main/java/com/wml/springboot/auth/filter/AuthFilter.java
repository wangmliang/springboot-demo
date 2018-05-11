package com.wml.springboot.auth.filter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wml.SpringContextHolder;
import com.wml.springboot.auth.SessionContext;
import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>Title：</b>AuthFilter.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/9 - 17:40<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Order(1)
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    public static final String JSP_SUFFIX = "jsp";
    public static final String AJAX_SUFFIX = "ajax";
    private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    private AuthService authService;

    public AuthService getAuthService() {
        return this.authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 初始化
     */
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * 过滤操作
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String contextPath = httpRequest.getContextPath();
        String servletPath = httpRequest.getServletPath();

        servletPath = servletPath.replaceAll("\\//", "/");

        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        this.authService = factory.getBean(AuthService.class);

        /**
         * 过滤例外鉴权操作
         */
        if (servletPath.contains("plugins") || servletPath.contains("src") || servletPath.contains("build") || servletPath.contains("css")
                || this.authService.authExclude(servletPath) || servletPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = SessionContext.getContext().getSession(httpRequest.getSession(true).getId());
        Staff staff = session == null ? null : (Staff) session.getAttribute("LOGIN_STAFF");
        /**
         * 结尾以"/"或者servletPath为""则跳转拦截登录
         */
        if (("/".equals(servletPath)) || ("".equals(servletPath)) || (servletPath.equals("/login"))) {
            /**
             * 已登录后误操作直接跳转主页面
             */
            if (null != staff) {
                httpResponse.sendRedirect(new StringBuilder().append(contextPath).append("/index").toString());
                return;
            }
        }
        /**
         * 未登录拦截跳转至登录页
         */
        if (staff == null) {
            forceToLogin(httpRequest, httpResponse, contextPath, servletPath);
            return;
        }
        System.out.println(new StringBuilder().append("是否从session获得用户：").append(staff != null).toString());
        if (this.authService.notNeedAuthAfterLogin(servletPath)) {
            System.out.println(new StringBuilder().append("url[").append(servletPath).append("]属于登录后不鉴权。").toString());
            chain.doFilter(request, response);
            return;
        }
        System.out.println(new StringBuilder().append("***********用户[").append(staff.getStaffId()).append("]已登录*************").toString());
        /**
         * 鉴权拦截
         */
        if (!this.authService.authorize(staff.getStaffId(), servletPath)) {
            System.out.println(new StringBuilder().append("***用户[").append(staff.getStaffId()).append("]鉴权失败*****").append(", 请求地址：" + servletPath).toString());
            if (isAjaxRequest(httpRequest)) {
                Map<String, Object> result = new HashMap<>();
                result.put("code", 1);
                result.put("message", "用户没有权限");
                result.put("redirectUrl", new StringBuilder().append(contextPath).append("/403").toString());
                sendError(httpResponse, result);
            } else {
                httpResponse.sendRedirect(new StringBuilder().append(contextPath).append("/403").toString());
            }
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * 销毁
     */
    public void destroy() {
    }

    /**
     * 跳转登录页
     * @param request
     * @param response
     * @param contextPath
     * @param servletPath
     * @throws IOException
     * @author WML
     * 2016年11月8日 - 下午5:55:57
     */
    private void forceToLogin(HttpServletRequest request, HttpServletResponse response, String contextPath, String servletPath)
            throws IOException {
        System.out.println("forceToLogin....");
        if (isAjaxRequest(request)) {
            Map<String, Object> result = new HashMap<>();
            result.put("code", 3);
            result.put("message", "用户未登录");
            result.put("redirectUrl", new StringBuilder().append(contextPath).append("/login").toString());
            sendError(response, result);
        } else {
            System.out.println("************重定向到登录页面*****************");
            response.sendRedirect(new StringBuilder().append(contextPath).append("/login").toString());
        }
    }

    /**
     * 跳转错误页
     * @param response
     * @param result
     * @author WML
     * 2016年11月8日 - 下午5:55:32
     */
    @SuppressWarnings("deprecation")
    private void sendError(HttpServletResponse response, Map<String, Object> result) {
        try {
            JsonGenerator jsonGenerator = null;
            ObjectMapper objectMapper = new ObjectMapper();
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
            jsonGenerator.writeObject(result);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * 是否Ajax请求
     * @param request
     * @return
     * @author WML
     * 2016年11月8日 - 下午5:55:19
     */
    public boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("x-requested-with");
        return (null != xRequestedWith) && ("XMLHttpRequest".equalsIgnoreCase(xRequestedWith));
    }


}
