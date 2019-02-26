/**
 * 
 */
package com.jxxy.mlxc.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * @Project:mlxc-news-service
 * @Class:NewsApplication.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午3:12:25
 * @Description:
 * @Version: 1.0.0 
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages="com.jxxy.mlxc.news")
@EnableAutoConfiguration
@MapperScan(
		basePackages="com.jxxy.mlxc.news.mapper",
		sqlSessionFactoryRef="sqlSessionFactory")
@EnableDubboConfiguration
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
}
