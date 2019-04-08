/**
 * 
 */
package com.mlxc.basic.mapper;

import java.util.List;

import com.mlxc.basic.dto.BaseDO;
import com.mlxc.basic.dto.BaseDto;
import com.mlxc.basic.query.BaseQuery;

/**
 * 
 * @Project:mlxc-basic
 * @Class:BaseDAO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午10:03:42
 * @Description:
 *
 */
public interface BaseDAO<T extends BaseDto> {
	/**
	 * 
	 * @Param:
	 * @Return:int
	 */
	int insert(T dto);
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
	int update(T dto);
	/**
	 * 
	 * @Param:
	 * @Return:T
	 */
	T select(long id);
	/**
	 * 
	 * @Param:
	 * @Return:List<T>
	 */
	List<T> find(BaseQuery query);
}
