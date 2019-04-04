package com.jxxy.mlxc.news.api.query;

import com.mlxc.basic.query.BaseQuery;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Project:mlxc-parent
 * @Class:CommentQuery
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日15:56
 * @Description:评论查看（主要查看与我相关的评论），userId可以根据shiro获取
 * @Version: 1.0.0
 */
@Data
@Alias("commentQuery")
public class CommentQuery extends BaseQuery {
    /**需要新闻模块，提供给前端一个获取我发布新闻的接口*/
    private Long newsId;
    /**模糊查找*/
    private String NewsTitle;
    /**模糊查找*/
    private String userName;
    /**以上条件是文章作者获取留言逻辑*/
    /**以下是读者或者文章作者留言逻辑*/
}
