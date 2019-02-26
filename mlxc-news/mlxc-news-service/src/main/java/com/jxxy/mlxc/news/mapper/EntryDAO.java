/**
 * 
 */
package com.jxxy.mlxc.news.mapper;

import java.util.List;

import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.dto.UserDto;
import com.jxxy.mlxc.news.api.model.EntryDO;
import com.jxxy.mlxc.news.api.query.EntryQuery;
import com.mlxc.basic.mapper.BaseDAO;

/**
 * @Project:mlxc-news-service
 * @Class:EntryDAO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午1:21:50
 * @Description:
 * @Version: 1.0.0 
 *
 */
public interface EntryDAO extends BaseDAO<EntryDto>{

	/**
	 * 根据用户id，查询出该用户所参加的所有活动
	 * @Param:
	 * @Return:List<ActiveDto>
	 */
	List<ActiveDto> findUserActives(EntryQuery query);
	/**
	 * 查询出某活动的所有参与用户
	 * @Param:
	 * @Return:List<UserDto>
	 */
	List<UserDto> findActiveUsers(EntryQuery query);
	/**
	 * 用户取消报名
	 * @Param:
	 * @Return:Integer
	 */
	Integer unEntry(EntryDO DO);
}
