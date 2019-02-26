/**
 * 
 */
package com.jxxy.mlxc.news.api.dto;

import org.apache.ibatis.type.Alias;

import com.mlxc.basic.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:NewsDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午11:05:00
 * @Description:新闻dto
 * 
 */
@Getter
@Setter
@ToString
@Alias("newsDto")
public class NewsDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4896599957998356965L;

	private String title;
	private String intro;
	private String content;
	private Long createUserId;
	private String createUserName;
	private Long updateUserId;
	private String updateUserName;
	private Long activeId;
	private String activeName;
	/**
	 * 评分
	 */
	private Long grade;
	private String type;
	
}
