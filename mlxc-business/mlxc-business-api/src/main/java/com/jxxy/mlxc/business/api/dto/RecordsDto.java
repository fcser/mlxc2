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
 * @Class:RecordsDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月17日下午1:04:04
 * @Description:订单详情dto
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class RecordsDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440162711601603269L;

	private String userName;
	private String userPhone;
	private Long productId;
	private String productName;
	/**
	 * 单价，打完折后的
	 */
	private Double price;
	/**
	 * 订购数量
	 */
	private Integer count;
	/**
	 * 备注
	 */
	private String decription;
	/**
	 * 总价
	 */
	private Double sum;
}
