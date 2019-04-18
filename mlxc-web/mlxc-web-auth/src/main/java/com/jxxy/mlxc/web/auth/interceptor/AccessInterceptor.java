package com.jxxy.mlxc.web.auth.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Project:mlxc-parent
 * @Class:AccessInterceptor
 * @author:zhouyangmin
 * @CreateTime:2019年04月13日16:01
 * @Description:解决跨域问题的拦截器
 * @Version: 1.0.0
 */
@Component
public class AccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        //允许客户端发送cookie，true表示接收
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if(request.getHeader("Access-Control-Request-Method")!=null&&"OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS,PUT,DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
            response.addHeader("Access-Control-Max-Age", "120");
        }
        return true;
    }
}
