/**
 * 
 */
package com.jxxy.mlxc.news.converter;

import org.mapstruct.Mapper;

import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.model.EntryDO;

/**
 * @Project:mlxc-news-service
 * @Class:EntryConverter.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午2:13:47
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Mapper(componentModel="spring")
public interface EntryConverter {

	EntryDO fromEntryDto(EntryDto dto);
}
