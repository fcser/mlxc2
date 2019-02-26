/**
 * 
 */
package com.jxxy.mlxc.news.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;

/**
 * @Project:mlxc-news-service
 * @Class:NewsConverter.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午4:30:50
 * @Description:news实体转换器
 * @Version: 1.0.0 
 *
 */
@Mapper(componentModel = "spring")
public interface NewsConverter {

	//public static NewsConverter INSTANCE = Mappers.getMapper(NewsConverter.class);
	/**
	 * dto转do
	 * @Param:
	 * @Return:NewsDO
	 */
	@Mappings({
		@Mapping(source="dto.title",target="title"),
		@Mapping(source="dto.intro",target="intro"),
		@Mapping(source="dto.id",target="id"),
		@Mapping(source="dto.content",target="content")
	})
	NewsDO fromNewsDto(NewsDto dto);
	/**
	 * do转dto
	 * @Param:
	 * @Return:NewsDto
	 */
	//NewsDto fromNewsDo(NewsDO newsDO);
}
