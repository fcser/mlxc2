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
 * @Class:NewsDO.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午11:24:14
 * @Description:与数据库字段对应
 * 
 */
@Getter
@Setter
@ToString
public class NewsDO extends BaseDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -64123432127718497L;

	private String title;
	private String intro;
	private String content;
	private Long createUserId;
	private Long updateUserId;
	private Long activeId;
	/**
	 * 评分
	 */
	private Integer grade;
	private String type;
}
