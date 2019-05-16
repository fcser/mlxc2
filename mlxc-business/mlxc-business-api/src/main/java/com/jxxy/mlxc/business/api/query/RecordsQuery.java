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
 * @Class:RecordsQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月17日下午12:56:58
 * @Description:订单查询query
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class RecordsQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981186515093658067L;

	/**
	 * 用户手机号，模糊查询
	 */
	private String userPhone;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 产品id
	 */
	private Long productId;

	private Integer useFlag;
}
