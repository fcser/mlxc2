package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:MyCommentsDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日15:52
 * @Description:给我的文章的评论（留言）
 * @Version: 1.0.0
 */
@Data
public class MyCommentsDto extends BaseDto {

    private Long newsId;
    private String newsTitle;
    /**留言人id*/
    private Long userId;
    /**留言人姓名*/
    private String userName;
    /**留言内容*/
    private String content;
    /**父留言内容*/
    private String fatherContent;
}
