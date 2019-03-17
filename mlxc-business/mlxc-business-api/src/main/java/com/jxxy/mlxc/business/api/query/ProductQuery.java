/**
 * 
 */
package com.jxxy.mlxc.business.api.query;

import com.mlxc.basic.query.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-business-api
 * @Class:ProductQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月17日下午12:53:30
 * @Description:产品查询dto
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ProductQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1614920464446550357L;

	/**
	 * 产品名称，模糊查找
	 */
	private String name;
}
