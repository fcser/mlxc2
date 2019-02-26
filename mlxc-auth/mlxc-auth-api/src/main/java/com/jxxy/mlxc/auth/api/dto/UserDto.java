/**
 * 
 */
package com.jxxy.mlxc.auth.api.dto;

import com.mlxc.basic.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-auth-api
 * @Class:UsersDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:45:46
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class UserDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 406815360586767386L;

	private String phone;
	private String password;
	private String userName;
	private Integer sex;
	private Integer age;
	private String signature;
	private Integer role;
	private String roleName;
}
