/**
 * 
 */
package com.jxxy.mlxc.business.mapper;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.query.ProductQuery;
import org.apache.ibatis.annotations.Param;

import com.jxxy.mlxc.business.api.dto.ProductDto;

import java.util.List;

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
	 * 减少库存量，乐观锁机制
	 * @Param:
	 * @Return:int
	 */
	int decreaseProduct(@Param("id") Long id,@Param("count")Integer count,@Param("version") Integer version);
	/**
	 * 插入数据
	 * @Param:
	 * @Return:Integer productId
	 */
	Long insert(ProductDto dto);
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
	int batchDelete(@Param("ids") List<Long> ids);
	/**
	 * 获取商品列表
	 * @Param:
	 * @Return:List<ProductDto>
	 */
	List<ProductDto> listProduct(ProductQuery query);

	/**
	 * 更新抢单商品
	 * @param grabSimgleDto
	 * @return
	 */
	int insertSeckill(GrabSimgleDto grabSimgleDto);
}
