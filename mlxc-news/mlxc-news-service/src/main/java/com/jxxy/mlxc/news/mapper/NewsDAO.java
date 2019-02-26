/**
 * 
 */
package com.jxxy.mlxc.news.mapper;

import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.mlxc.basic.mapper.BaseDAO;

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
}
