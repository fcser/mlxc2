package com.jxxy.mlxc.news.converter;

import com.jxxy.mlxc.news.api.dto.CommentDto;
import com.jxxy.mlxc.news.api.model.CommentDO;
import com.jxxy.mlxc.news.api.model.CommentDependDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Project:mlxc-parent
 * @Class:CommentConverter
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日18:59
 * @Description:
 * @Version: 1.0.0
 */
@Mapper(componentModel = "spring")
public interface CommentConverter {
    @Mappings({
            @Mapping(source="dto.id",target="commentId")
    })
    CommentDependDO toCommentDependDO(CommentDto dto);

    CommentDO toCommentDO(CommentDto dto);
}
