package com.jxxy.mlxc.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.CommentDependencyDto;
import com.jxxy.mlxc.news.api.dto.CommentDto;
import com.jxxy.mlxc.news.api.dto.MyCommentsDto;
import com.jxxy.mlxc.news.api.query.CommentQuery;
import com.mlxc.basic.query.BaseQuery;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CommentService
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日9:52
 * @Description:评论的service，仿极客时间文章评论
 * @Version: 1.0.0
 */

public interface CommentService {
    /**
     * 插入评论，相应的评论展示给作者看
     * @param commentDto
     */
    void insert(CommentDto commentDto);

    /**
     * 点赞
     */
    void giveALike();
    /**
     * 查询评论总数
     * @return
     */
    Integer countComments();

    /**
     * 查询评论留言，精选100条（先根据点赞数，若点赞数相同，则根据时间排序）
     * @param newsId
     * @return
     */
    List<CommentDependencyDto> getComments(Long newsId);

    /**
     * 查询给我的新闻评论（逻辑分，给文章作者）
     * @param commentQuery
     * @return
     */
    PageInfo<MyCommentsDto> getMyComments(CommentQuery commentQuery);
}
