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
 * @Class:PurchaseRecord.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午9:35:51
 * @Description:购买信息表
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class PurchaseRecordDO extends BaseDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1448212864281581930L;

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
