/**
 * 
 */
package com.jxxy.mlxc.news.mapper;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.mlxc.basic.mapper.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project:mlxc-news-api
 * @Class:NewsDAO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:50:02
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface NewsDAO extends BaseDAO<NewsDto> {

	/**
	 * 绑定活动id
	 * @Param:
	 * @Return:Long
	 */
	Long insertActiveId(NewsDO id);
	/**
	 * 是否已经点赞了
	 * @param userId
	 * @param newsId
	 * @return
	 */
	int isGiveALike(@Param("userId") Long userId, @Param("newsId") Long newsId);

	/**
	 * 点赞
	 * @param userId
	 * @param newsId
	 */
	void giveALike(@Param("userId") Long userId, @Param("newsId") Long newsId);

    /**
     * 更新点赞数量
     * @param newsId
     */
	void updateGood(Long newsId);
	/**
	 * 获取我发表的文章
	 * @return
	 */
	/*List<NewsDto> getMyArticle(NewsQuery newsQuery);*/

	/**
	 * 获取最新新闻（用于查询我的文章，获取最新新闻）
	 * @param newsQuery
	 * @return
	 */
	List<NewsDto> getNewsByTime(NewsQuery newsQuery);
}
