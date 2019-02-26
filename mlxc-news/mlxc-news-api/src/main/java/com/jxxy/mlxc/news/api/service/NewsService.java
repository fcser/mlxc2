/**
 * 
 */
package com.jxxy.mlxc.news.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.mlxc.basic.dto.BaseDO;

/**
 * @Project:mlxc-news-api
 * @Class:NewsService.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:48:11
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface NewsService {

	/**
	 * 关联活动
	 * @Param:
	 * @Return:Long
	 */
	Long insertActiveId(NewsDO newsDO);
	/**
	 * @Param:
	 * @Return:Long
	 */
	Long insert(NewsDto news);
	/**
	 * 分页查询新闻
	 * @Param:
	 * @Return:PageInfo<NewsDto>
	 */
	PageInfo<NewsDto> findByPage(NewsQuery query);
	/**
	 * 
	 * @Param:
	 * @Return:int
	 */
	int delete(Long id);
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
	NewsDto select(Long userId,Long id);
}
