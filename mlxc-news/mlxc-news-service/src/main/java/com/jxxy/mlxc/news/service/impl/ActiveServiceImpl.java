/**
 * 
 */
package com.jxxy.mlxc.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.constant.IsCall;
import com.jxxy.mlxc.news.api.query.ActiveQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.model.ActiveDO;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.service.ActiveService;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.news.converter.ActiveConverter;
import com.jxxy.mlxc.news.mapper.ActiveDAO;
import com.mlxc.basic.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * @Project:mlxc-news-service
 * @Class:ActiveServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日上午11:33:15
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Service(version="1.0.0",interfaceClass=ActiveService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class ActiveServiceImpl implements ActiveService{

	@Autowired
	private NewsService newsService;
	@Autowired
	private ActiveDAO activeDAO;

	@Override
	public Long insert(ActiveDto dto) {
		activeDAO.insert(dto);
		long newsId=dto.getNewsId();
		NewsDO newsDO=new NewsDO();
		newsDO.setActiveId(dto.getId());
		newsDO.setId(newsId);
		newsService.insertActiveId(newsDO);
		return dto.getId();
	}

	@Override
	public ActiveDto selectByNewsId(Long newsId) {
		return activeDAO.selectByNewsId(newsId);
	}

	@Override
	public PageInfo<ActiveDto> findActives(ActiveQuery activeQuery) {
		PageHelper.startPage(activeQuery.getPageNum(), activeQuery.getPageSize());
		List<ActiveDto> list=activeDAO.find(activeQuery);
		return new PageInfo<>(list);
	}

	@Override
	public boolean openMsg(long activeId, int isOpen) {
		if(!(IsCall.NOTCALL.getType().equals(isOpen)||IsCall.CALL.getType().equals(isOpen))){
			return false;
		}
		return activeDAO.openMsg(activeId,isOpen)==0?false:true;
	}

}
