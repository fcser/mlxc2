/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * @Project:mlxc-shiro
 * @Class:ShiroProperties.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月1日下午3:44:49
 * @Description:定义shiro的配置信息，废弃(使用最新的NewAuthProperties，在项目启动时，不会先去装配)
 * @Version: 1.0.0 
 *
 */
@Configuration
public class ShiroProperties {

	/**
	 * session超时时间
	 */
	private static  int sessionTime=1800000;

	@Value("${mlxc.shiro.sessionTime}")
	public void setSessionTime(int sessionTime){
		this.sessionTime=sessionTime;
	}
	public static int getSessionTime(){
		return sessionTime;
	}

	/**
	 * 无需权限访问
	 */
	private static String[] noFilter= {};
	@Value("${mlxc.shiro.noFilter}")
	public void setNoFilter(String[] noFilter){
		this.noFilter=noFilter;
	}
	public static String[] getNoFilter(){
		return noFilter;
	}

	/**
	 * 登录即可访问
	 */
	private static String[] authFilter= {};
	@Value("${mlxc.shiro.authFilter}")
	public void setAuthFilter(String[] authFilter){
		this.authFilter=authFilter;
	}
	public static String[] getAuthFilter(){
		return authFilter;
	}

	/**
	 * 管理员可访问
	 */
	private static String[] adminFilter={};
	@Value("${mlxc.shiro.adminFilter}")
	public void setAdminFilter(String[] adminFilter){
		this.adminFilter=adminFilter;
	}
	public static String[] getAdminFilter(){
		return adminFilter;
	}

	/**
	 * 商家登录可访问
	 */
	private static String[] businessFilter={};
	@Value("${mlxc.shiro.businessFilter}")
	public void setBusinessFilter(String[] businessFilter){
		this.businessFilter=businessFilter;
	}
	public static String[] getBusinessFilter(){
		return businessFilter;
	}

	private static boolean isOpen=false;
	@Value("${mlxc.shiro.isOpen}")
	public void setIsOpen(boolean isOpen){
		this.isOpen=isOpen;
	}
	public static boolean getIsOpen(){
		return isOpen;
	}
}
