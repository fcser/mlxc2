/**
 * 
 */
package com.jxxy.mlxc.news.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.NewsDataDto;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.mlxc.basic.dto.BaseDO;
import com.mlxc.basic.dto.BaseDto;

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
	 * 插入新闻
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
	 * 删除新闻
	 * @Param:
	 * @Return:int
	 */
	int delete(Long id);
	/**
	 * 批量删除
	 * @Param:
	 * @Return:int
	 */
	int batchDelete(List<Long> ids);
	/**
	 * 更新新闻内容
	 * @Param:
	 * @Return:int
	 */
	int update(NewsDto dto);
	/**
	 * 我查看新闻详情
	 * @Param:
	 * @Return:T
	 */
	NewsDto select(Long userId,Long id);

	/**
	 * 是否已经点赞了
	 * @param userId
	 * @param newsId
	 * @return
	 */
	int isGiveALike(Long userId,Long newsId);

	/**
	 * 点赞
	 * @param userId
	 * @param newsId
	 */
	void giveALike(Long userId,Long newsId);

	/**
	 * 获取我发表的文章
	 * @return
	 */
	PageInfo<NewsDto> getMyArticle(NewsQuery newsQuery);

	/**
	 * 获取最新新闻
	 * @param newsQuery
	 * @return
	 */
	PageInfo<NewsDto> getNewsByTime(NewsQuery newsQuery);

	/**
	 * 查询出最近的20条来重建缓存
	 * @return
	 */
	List<NewsDto> getNews();

	NewsDataDto getNewsData(Long newsId);
}
