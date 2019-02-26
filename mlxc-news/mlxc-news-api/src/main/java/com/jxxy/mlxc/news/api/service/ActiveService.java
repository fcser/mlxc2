/**
 * 
 */
package com.jxxy.mlxc.news.api.service;

import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.mlxc.basic.service.BaseService;

/**
 * @Project:mlxc-news-api
 * @Class:ActiveService.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:53:58
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface ActiveService extends BaseService<ActiveDto> {

	/**
	 * 插入活动
	 * @Param:
	 * @Return:Integer
	 */
	Long insert(ActiveDto dto);
	/**
	 * 根据新闻id，查询活动
	 * @Param:
	 * @Return:ActiveDto
	 */
	ActiveDto selectByNewsId(Long newsId);
	
}
