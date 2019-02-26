/**
 * 
 */
package com.jxxy.mlxc.news.converter;

import org.mapstruct.Mapper;

import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.model.ActiveDO;

/**
 * @Project:mlxc-news-service
 * @Class:ActiveConverter.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日上午10:34:59
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Mapper(componentModel="spring")
public interface ActiveConverter {

	ActiveDO fromActiveDto(ActiveDto dto);
}
