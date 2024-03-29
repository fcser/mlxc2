/**
 * 
 */
package com.jxxy.mlxc.business;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Project:mlxc-bussiness-service
 * @Class:BusinessApplication.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月21日上午9:39:29
 * @Description:
 * @Version: 1.0.0 
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages="com.jxxy.mlxc.business")
@MapperScan(
		basePackages="com.jxxy.mlxc",
		sqlSessionFactoryRef="sqlSessionFactory")
@EnableScheduling
@EnableDubboConfiguration
public class BusinessApplication {

	/**
	 * @Param:
	 * @Return:void
	 */
	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);

	}

}
