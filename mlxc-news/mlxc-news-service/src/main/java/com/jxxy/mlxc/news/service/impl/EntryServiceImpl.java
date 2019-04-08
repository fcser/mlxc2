/**
 * 
 */
package com.jxxy.mlxc.news.service.impl;

import java.util.List;

import com.jxxy.mlxc.news.api.dto.EntryUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.dto.UserDto;
import com.jxxy.mlxc.news.api.model.EntryDO;
import com.jxxy.mlxc.news.api.query.EntryQuery;
import com.jxxy.mlxc.news.api.service.EntryService;
import com.jxxy.mlxc.news.converter.EntryConverter;
import com.jxxy.mlxc.news.mapper.EntryDAO;

/**
 * @Project:mlxc-news-service
 * @Class:EntryServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午2:04:14
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Service(version="1.0.0",interfaceClass=EntryService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryDAO entryDAO;
	@Autowired
	private EntryConverter converter;
	@Override
	public Long insert(EntryDto dto) {
		EntryDO entry=converter.fromEntryDto(dto);
		entryDAO.insert(entry);
		return entry.getId();
	}

	@Override
	public void unEntry(EntryDto dto) {
		EntryDO entry=converter.fromEntryDto(dto);
		entryDAO.unEntry(entry);
	}

	@Override
	public PageInfo<ActiveDto> findUserActives(EntryQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		List<ActiveDto> list=entryDAO.findUserActives(query);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<EntryUserDto> findActiveUsers(EntryQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		List<EntryUserDto> list=entryDAO.findActiveUsers(query);
		return new PageInfo<>(list);
	}
	@Override
	public boolean isEntry(Long activeId,Long userId){
		return entryDAO.isEntry(activeId,userId)>0?true:false;
	}
	
}
