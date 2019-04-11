/**
 * 
 */
package com.jxxy.mlxc.news.mapper;

import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.dto.ActiveUserDto;
import com.mlxc.basic.mapper.BaseDAO;

import java.util.List;

/**
 * @Project:mlxc-news-service
 * @Class:ActiveDAO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日上午10:34:09
 * @Description:
 * @Version: 1.0.0 
 *
 */

public interface ActiveDAO extends BaseDAO<ActiveDto>{

	/**
	 * 根据新闻id，查询出绑定需要的活动
	 * @Param:newsId
	 * @Return:ActiveDto
	 */
	ActiveDto selectByNewsId(Long id);

	/**
	 * 根据特定格式时间查询出活动
	 * yyyy-MM-dd HH
	 * @param date
	 * @return
	 */
	List<ActiveUserDto> selectActiveByTime(String date);
}
