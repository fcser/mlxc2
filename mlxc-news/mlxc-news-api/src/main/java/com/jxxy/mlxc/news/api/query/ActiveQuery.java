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
 * @Class:ActiveQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:44:39
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ActiveQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6809430917774900366L;
	private Long createUserId;
}
