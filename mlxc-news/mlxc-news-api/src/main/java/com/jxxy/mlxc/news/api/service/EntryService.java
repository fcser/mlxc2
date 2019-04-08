/**
 * 
 */
package com.jxxy.mlxc.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.dto.EntryUserDto;
import com.jxxy.mlxc.news.api.dto.UserDto;
import com.jxxy.mlxc.news.api.query.EntryQuery;

/**
 * @Project:mlxc-news-api
 * @Class:EntryService.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:58:31
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface EntryService{

	/**
	 * 插入报名表
	 * @Param:
	 * @Return:Long 报名表id
	 */
	Long insert(EntryDto dto);

	/**
	 * 查看用户是否已经报名
	 * @param activeId
	 * @param userId
	 * @return true已经报名，false未报名
	 */
	boolean isEntry(Long activeId,Long userId);
	/**
	 * 取消报名
	 * @Param:
	 * @Return:void
	 */
	void unEntry(EntryDto dto);
	/**
	 * 查询出用户报名的活动
	 * @Param:
	 * @Return:ActiveDto
	 */
	PageInfo<ActiveDto> findUserActives(EntryQuery query);
	/**
	 * 查询出活动的报名表
	 * @Param:
	 * @Return:UserDto
	 */
	PageInfo<EntryUserDto> findActiveUsers(EntryQuery query);
}
