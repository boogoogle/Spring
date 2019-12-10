package com.booo.spring.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        return true;
//        if(user == null) {
//            //未登录
//            return false;
//        } else {
//
//            // 转发
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return true;
//        }
    }
}
