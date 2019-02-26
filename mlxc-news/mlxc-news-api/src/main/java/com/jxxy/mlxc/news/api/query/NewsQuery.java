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
 * @Class:NewsQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:37:46
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class NewsQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1881589588499161312L;
	/**
	 * 按类别查询
	 */
	private String type;
	/**
	 * 根据用户查询
	 */
	private Long createUserId;
}
