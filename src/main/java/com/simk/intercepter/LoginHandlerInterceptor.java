package com.simk.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //调用目标方法前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        } else {
            request.setAttribute("msg","用户未登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
    }
}
