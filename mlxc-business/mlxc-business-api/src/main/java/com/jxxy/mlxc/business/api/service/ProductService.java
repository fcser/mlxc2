/**
 * 
 */
package com.jxxy.mlxc.business.api.service;

import java.util.List;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.jxxy.mlxc.business.api.query.ProductQuery;

/**
 * @Project:mlxc-business-api
 * @Class:ProductService.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月17日下午1:51:37
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface ProductService {

	/**
	 * 插入数据
	 * @Param:
	 * @Return:Integer productId
	 */
	Long add(ProductDto dto);
	/**
	 * 修改
	 * @Param:
	 * @Return:void
	 */
	void update(ProductDto dto);
	/**
	 * 删除数据
	 * @Param:
	 * @Return:void
	 */
	void delete(Long id);
	/**
	 * 批量删除
	 * @Param:
	 * @Return:int
	 */
	int batchDelete(List<Long> ids);
	/**
	 * 获取商品列表
	 * @Param:
	 * @Return:List<ProductDto>
	 */
	List<ProductDto> listProduct(ProductQuery query);
	/**
	 * 显示商品信息(取最近上传的一条商品)
	 * @Param:
	 * @Return:ProductDto
	 */
	ProductDto showProduct();

	/**
	 * 通过id获取产品信息
	 * @param id
	 * @return
	 */
	ProductDto getProductById(Long id);


}
