/**
 * 
 */
package com.jxxy.mlxc.auth.mapper;

import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.mlxc.basic.mapper.BaseDAO;

/**
 * @Project:mlxc-auth-service
 * @Class:UserDAO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午4:04:29
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface UserDAO extends BaseDAO<UserDto>{

	/**
	 * 进行用户登录
	 *@param:
	 *@return:UserDto
	 *
	 */
	UserDto getUserByPhone(String phone);
}
