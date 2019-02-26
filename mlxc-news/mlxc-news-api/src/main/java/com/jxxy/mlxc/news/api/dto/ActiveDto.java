/**
 * 
 */
package com.jxxy.mlxc.news.api.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.mlxc.basic.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:ActiveDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:19:52
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ActiveDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6224546263699710269L;
	
	@NotBlank(message="活动名称不允许为空")
	private String activeName;
	@NotBlank(message="活动必须绑定新闻")
	private Long newsId;
	private String place;
	private Date time;
	private String intro;
	/**
	 * 策划人
	 */
	private String plotter;
	private String decription;
	private String filePath;
	private Long createUserId;
	private String createUserName;
	/**
	 * 是否启用电话提醒,默认0，不通知
	 */
	private Integer isCall;
}
