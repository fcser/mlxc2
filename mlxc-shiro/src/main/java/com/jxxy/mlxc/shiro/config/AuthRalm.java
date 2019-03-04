/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.jxxy.mlxc.auth.api.service.UserService;

/**
 * @Project:mlxc-shiro
 * @Class:AuthRalm.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日下午9:06:34
 * @Description:认证与授权
 * @Version: 1.0.0 
 *
 */
public class AuthRalm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken =(UsernamePasswordToken)token;
		UserDto user=userService.getUserByPhone(upToken.getUsername());
		if(null!=user) {
			return new SimpleAuthenticationInfo(user.getPhone(),user.getPassword(),getName());
		}
		return null;
	}

}
