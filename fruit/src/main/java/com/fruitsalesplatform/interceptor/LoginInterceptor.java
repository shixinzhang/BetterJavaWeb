package com.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录信息拦截器
 * <p>
 * Created by zhangshixin on 19/8/5.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        System.out.println("preHandle: " + uri);

        if (uri.contains("Login") || uri.contains("login") || uri.contains("register")) {
            //去登录、注册页的
            return true;
        }

        if (httpServletRequest.getSession().getAttribute("user") != null) {
            //已登录
            return true;
        }

        if (uri.contains("css") || uri.contains("js") || uri.contains("images")) {
            //静态资源
            return true;
        }
        //没登录
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toLogin.action");
        return false;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
