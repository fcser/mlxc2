/**
 * 
 */
package com.jxxy.mlxc.auth.api.service;

import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.mlxc.basic.service.BaseService;

/**
 * @Project:mlxc-auth-api
 * @Class:UserService.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:52:27
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface UserService extends BaseService<UserDto>{

	/**
	 * 用于登录
	 *@param:
	 *@return:UserDto
	 *@throws:
	 *@deprecated:
	 *
	 */
	UserDto getUserByPhone(String phone);
}

