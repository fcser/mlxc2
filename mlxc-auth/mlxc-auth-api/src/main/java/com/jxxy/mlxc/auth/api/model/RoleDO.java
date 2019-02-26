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
 * @Class:RoleDO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:43:02
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class RoleDO extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7849718897658549433L;
	private String roleName;
	private String decription;
	private String permission;
}
