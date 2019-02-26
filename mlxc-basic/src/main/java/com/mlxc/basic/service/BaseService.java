/**
 * 
 */
package com.mlxc.basic.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mlxc.basic.dto.BaseDO;
import com.mlxc.basic.dto.BaseDto;
import com.mlxc.basic.query.BaseQuery;

/**
 * @Project:mlxc-basic
 * @Class:BaseService.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午10:05:40
 * @Description:
 * 
 */
public interface BaseService<T extends BaseDto> {

	/**
	 * 
	 * @Param:
	 * @Return:T
	 */
	Long insert(BaseDO dto);
	/**
	 * 
	 * @Param:
	 * @Return:int
	 */
	int delete(long id);
	/**
	 * 
	 * @Param:
	 * @Return:int
	 */
	int batchDelete(List<Long> ids);
	/**
	 * 
	 * @Param:
	 * @Return:int
	 */
	int update(BaseDO dto);
	/**
	 * 
	 * @Param:
	 * @Return:T
	 */
	T select(long id);
	/**
	 * 
	 * @Param:
	 * @Return:PageInfo<T>
	 */
	PageInfo<T> findByPage(BaseQuery query);
}