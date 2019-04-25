package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:CommentDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日14:04
 * @Description:评论dto，作插入
 * @Version: 1.0.0
 */
@Data
public class CommentDto extends BaseDto {

    private static final long serialVersionUID = 3222530214280623115L;
    private Long newsId;
    private String content;
    private Long commentUserId;
    private Integer goodNum;
    /**依赖的父评论的id*/
    private Long fatherCommentId;
    /**是否恢复*/
    private Integer shouldReply;
}
