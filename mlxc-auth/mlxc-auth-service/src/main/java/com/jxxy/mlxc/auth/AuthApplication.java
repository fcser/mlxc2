/**
 * 
 */
package com.jxxy.mlxc.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * @Project:mlxc-auth-service
 * @Class:AuthApplication.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:54:54
 * @Description:
 * @Version: 1.0.0 
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages="com.jxxy.mlxc.auth")
@EnableAutoConfiguration
@MapperScan(
		basePackages="com.jxxy.mlxc.auth.mapper",
		sqlSessionFactoryRef="sqlSessionFactory")
@EnableDubboConfiguration
public class AuthApplication {

	/**
	 * @Param:
	 * @Return:void
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
