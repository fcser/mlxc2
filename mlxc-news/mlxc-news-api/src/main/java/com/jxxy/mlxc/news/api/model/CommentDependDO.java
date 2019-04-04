package com.jxxy.mlxc.news.api.model;

import com.mlxc.basic.dto.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Project:mlxc-parent
 * @Class:CommentTwoDO
 * @author:zhouyangmin
 * @CreateTime:2019年04月03日21:30
 * @Description:评论依赖
 * @Version: 1.0.0
 */
@Data
@Alias("commentDependDO")
public class CommentDependDO extends BaseDO {

    private static final long serialVersionUID = -8607990833754650092L;
    private Long commentId;
    private Long fatherCommentId;
}
