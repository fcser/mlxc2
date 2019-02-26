/**
 * 
 */
package com.jxxy.mlxc.auth.api.query;

import com.mlxc.basic.query.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-auth-api
 * @Class:UsersQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午3:50:14
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class UserQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6899478591525554691L;
	
	private Integer roleId;

}
