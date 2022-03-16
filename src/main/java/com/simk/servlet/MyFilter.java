package com.simk.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//过滤哪些请求
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
@WebFilter(urlPatterns = {"/main.html"})
/*
        urlPatterns
        配置要拦截的资源
        以指定资源匹配。例如"/index.jsp"
        以目录匹配。例如"/servlet/*"
        以后缀名匹配，例如"*.jsp"
        通配符，拦截所有web资源。"/*"
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("“filter销毁”");
    }
}