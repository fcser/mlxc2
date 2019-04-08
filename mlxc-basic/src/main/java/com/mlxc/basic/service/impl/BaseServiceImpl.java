/**
 * 
 */
package com.mlxc.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlxc.basic.dto.BaseDO;
import com.mlxc.basic.dto.BaseDto;
import com.mlxc.basic.mapper.BaseDAO;
import com.mlxc.basic.query.BaseQuery;
import com.mlxc.basic.service.BaseService;

/**
 * @Project:mlxc-basic
 * @Class:BaseServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午10:11:18
 * @Description:
 * 
 */
@Service("baseService")
public class BaseServiceImpl<T extends BaseDto> implements BaseService<T> {

	@Autowired
	private BaseDAO<T> baseDao;
	
	@Override
	public Long insert(T dto) {
		baseDao.insert(dto);
		return dto.getId();
	}

	@Override
	public int delete(long id) {
		return baseDao.delete(id);
	}

	
	@Override
	public int batchDelete(List<Long> ids) {
		return baseDao.batchDelete(ids);
	}

	
	@Override
	public int update(T dto) {
		return baseDao.update(dto);
	}

	
	@Override
	public T select(long id) {
		return baseDao.select(id);
	}

	@Override
	public PageInfo<T> findByPage(BaseQuery query) {
		PageHelper.startPage(query.getPageNum(),query.getPageSize());
		List<T> list=baseDao.find(query);
		return new PageInfo<>(list);
	}
	

}

