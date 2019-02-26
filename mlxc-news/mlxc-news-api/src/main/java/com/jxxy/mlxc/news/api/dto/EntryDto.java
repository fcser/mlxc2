/**
 * 
 */
package com.jxxy.mlxc.news.api.dto;

import java.util.List;

import com.mlxc.basic.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-news-api
 * @Class:EntryDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午2:28:21
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Getter
@Setter
@ToString
public class EntryDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2640465357148351252L;
	
	private Long entryUserId;
	private List<UserDto> entryUsers;
	private Long activeId;
	private List<ActiveDto> active;
	private String decription; 

}
