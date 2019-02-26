/**
 * 
 */
package com.jxxy.mlxc.news.api.query;

import com.mlxc.basic.query.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:EntryQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:41:09
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class EntryQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1150073812831139109L;

	/**
	 * 查询我报名的活动
	 */
	private Long entryUserId; 
	/**
	 * 查询活动有多少人报名
	 */
	private Long activeId;
}
