package com.jxxy.mlxc.web.auth.config;

import com.jxxy.mlxc.web.auth.interceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Project:mlxc-parent
 * @Class:WebMvcConfig
 * @author:zhouyangmin
 * @CreateTime:2019年04月13日16:04
 * @Description:注册拦截器
 * @Version: 1.0.0
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AccessInterceptor accessInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
    }
}
