/**
 * 
 */
package com.jxxy.mlxc.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.jxxy.mlxc.auth.api.service.UserService;
import com.jxxy.mlxc.auth.mapper.UserDAO;
import com.mlxc.basic.service.impl.BaseServiceImpl;

/**
 * @Project:mlxc-auth-service
 * @Class:UserServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午4:12:43
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Service(version="1.0.0",interfaceClass=UserService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserDto> implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDto getUserByPhone(String phone) {
		return userDAO.getUserByPhone(phone);
	}

}
