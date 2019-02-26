/**
 * 
 */
package com.jxxy.mlxc.auth.api.model;

import com.mlxc.basic.dto.BaseDO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-auth-api
 * @Class:UsersDO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:36:35
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class UserDO extends BaseDO{/**
	 * 
	 */
	private static final long serialVersionUID = -7133939726749448481L;

	private String phone;
	private String password;
	private String userName;
	private Integer sex;
	private Integer age;
	private String signature;
	private Integer role;
	
}
