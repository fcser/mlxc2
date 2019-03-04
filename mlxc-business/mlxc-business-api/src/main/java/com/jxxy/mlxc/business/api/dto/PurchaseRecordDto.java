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
 * @Class:PurchaseRecordDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午11:18:24
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class PurchaseRecordDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6467435522122661091L;
	private Long userId;
	private Long productId;
	private Double price;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 总价
	 */
	private Double sum;
	private String decription;
}
