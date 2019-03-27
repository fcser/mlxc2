/**
 * 
 */
package org.mlxc.bussiness.service;

import com.jxxy.mlxc.business.api.dto.ProductDto;

/**
 * @Project:mlxc-bussiness-service
 * @Class:PriceTest.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午10:14:54
 * @Description:
 * @Version: 1.0.0 
 *
 */
public class PriceTest {

	public static void main(String[] args) {
		ProductDto dto=new ProductDto();
		//dto.setOriginalPrice(9.0);
		dto.setDiscount(7);
		//System.out.println("现价："+dto.getNowPrice());
	}
}
