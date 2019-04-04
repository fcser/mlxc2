package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CommentDependencyDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日14:12
 * @Description:评论列表查询
 * @Version: 1.0.0
 */

@Data
public class CommentDependencyDto extends BaseDto {

    private static final long serialVersionUID = 6994033513939068181L;
    private String content;
    //private Long commentUserId;
    private String userName;
    private Integer goodNum;
    private List<CommentDependencyDto> childComments;
}
