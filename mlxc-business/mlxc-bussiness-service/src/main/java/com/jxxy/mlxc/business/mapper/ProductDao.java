/**
 * 
 */
package com.jxxy.mlxc.business.mapper;

import org.apache.ibatis.annotations.Param;

import com.jxxy.mlxc.business.api.dto.ProductDto;

/**
 * @Project:mlxc-bussiness-service
 * @Class:ProductDao.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午9:49:21
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface ProductDao {

	/**
	 * 获取产品表
	 * @Param:
	 * @Return:ProductDto
	 */
	ProductDto getProduct(Long id);
	/**
	 * 减少库存量
	 * @Param:
	 * @Return:int
	 */
	int decreaseProduct(@Param("id") Long id,@Param("count")Integer count);
}
