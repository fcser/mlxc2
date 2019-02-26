/**
 * 
 */
package com.jxxy.mlxc.news.api.model;

import com.mlxc.basic.dto.BaseDO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:Entry.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:03:00
 * @Description:活动报名表
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class EntryDO extends BaseDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2856828008288664320L;

	private Long entryUserId;
	private Long activeId;
	private String decription;
}
