/**
 * 
 */
package com.jxxy.mlxc.business.api.dto;

import com.mlxc.basic.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-business-api
 * @Class:ProductDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午10:10:51
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ProductDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2267926348183818355L;

	private String name;
	private String decription;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 原价
	 */
	private Double price=0.0;
	/**
	 * 折扣
	 */
	private Integer discount=10;
	private Double nowPrice;
	/**
	 * 订单量
	 */
	private Integer num;

	private Integer version;
}
