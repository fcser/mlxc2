/**
 * 
 */
package com.jxxy.mlxc.news.api.model;

import java.util.Date;

import com.mlxc.basic.dto.BaseDO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:Active.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午1:54:21
 * @Description:活动表DO
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class ActiveDO extends BaseDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8763980015655852400L;

	private String activeName;
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
	/**
	 * 是否启用电话提醒,默认0，不通知
	 */
	private Integer isCall;
}
