/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.jxxy.mlxc.auth.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Project:mlxc-shiro
 * @Class:AuthRalm.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日下午9:06:34
 * @Description:认证与授权
 * @Version: 1.0.0 
 *
 */
@Slf4j
public class AuthRalm extends AuthorizingRealm{

	@Reference(version="1.0.0")
	private UserService userService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("come");
		UserDto user=userService.getUserByPhone(principals.getPrimaryPrincipal().toString());
		log.info("AuthorizationInfo user:{}",user==null?"NULL USER":user.toString());
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		if(null!=user){
			simpleAuthorizationInfo.addRole(user.getRoleName());
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken =(UsernamePasswordToken)token;
		String userName=upToken.getUsername();
		UserDto user=userService.getUserByPhone(userName);
		log.info("AuthorizationInfo user:{}",user==null?"NULL USER":user.toString());
		if(null!=user) {
			return new SimpleAuthenticationInfo(user.getPhone(),user.getPassword(),getName());
		}
		return null;
	}

}
