/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @Project:mlxc-shiro
 * @Class:ShiroProperties.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月1日下午3:44:49
 * @Description:定义shiro的配置信息
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ConfigurationProperties(prefix="mlxc.auth")
public class ShiroProperties {

	/**
	 * session超时时间
	 */
	private int sessionTime=1800000;
	/**
	 * 网址
	 */
	private String prefix="";
	//private AuthDefaultAdminProperties developAdmin;
	private String[] noFilter= {};
	private String[] authFilter= {};
	
}
