/**
 * 
 */
package com.jxxy.mlxc.business.api.model;

import com.mlxc.basic.dto.BaseDO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-business-api
 * @Class:ProductDO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午9:29:56
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ProductDO extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1153365751815168258L;

	private String name;
	private String decription;
	/**
	 * 库存
	 */
	private Integer stock;
	private Double price;
	/**
	 * 折扣
	 */
	private Integer discount;
	/**
	 * 版本号
	 */
	private Integer version;
}
