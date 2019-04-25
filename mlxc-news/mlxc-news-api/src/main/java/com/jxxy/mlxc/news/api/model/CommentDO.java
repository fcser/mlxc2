package com.jxxy.mlxc.news.api.model;

import com.mlxc.basic.dto.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Project:mlxc-parent
 * @Class:CommentOneDO
 * @author:zhouyangmin
 * @CreateTime:2019年04月03日21:29
 * @Description:一级评论
 * @Version: 1.0.0
 */
@Data
@Alias("commentDO")
public class CommentDO extends BaseDO {

    private static final long serialVersionUID = 8437267752411491801L;
    private Long newsId;
    private String content;
    private Long CommentUserId;
    private Integer goodNum;
    //是否应该回复
    private Integer shouldReply;
}
