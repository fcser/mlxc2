/**
 * 
 */
package com.jxxy.mlxc.news.service.impl;

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
public class ActiveServiceImpl extends BaseServiceImpl<ActiveDto> implements ActiveService {

	@Autowired
	private NewsService newsService;
	@Autowired
	private ActiveDAO activeDAO;

	@Autowired
	private ActiveConverter activeConverter;
	@Override
	public Long insert(ActiveDto dto) {
		ActiveDO DO=activeConverter.fromActiveDto(dto);
		activeDAO.insert(DO);
		long newsId=dto.getNewsId();
		NewsDO newsDO=new NewsDO();
		newsDO.setActiveId(DO.getId());
		newsDO.setId(newsId);
		newsService.insertActiveId(newsDO);
		return DO.getId();
	}

	@Override
	public ActiveDto selectByNewsId(Long newsId) {
		return activeDAO.selectByNewsId(newsId);
	}

}
