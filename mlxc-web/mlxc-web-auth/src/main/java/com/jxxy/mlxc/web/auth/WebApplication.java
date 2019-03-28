package com.jxxy.mlxc.web.auth;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 
 * @Project:mlxc-web-auth
 * @Class:App.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月1日下午7:43:29
 * @Description:
 * @Version: 1.0.0 
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages="com.jxxy.mlxc")
@EnableDubboConfiguration
public class WebApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(WebApplication.class, args);
    }
}
