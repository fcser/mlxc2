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
     * 查看是否已经给过赞了
     * @param id
     * @param userId
     * @return true已点赞，false未点赞
     */
    boolean isGiveLike(Long id,Long userId);
    /**
     * 点赞
     * @param id，评论id
     * @param userId
     */
    void giveALike(Long id,Long userId);
    /**
     * 查询评论总数
     * @return
     */
    Integer countComments(Long newsId);

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

    /**
     * 获取我未处理的评论数
     * @param userId
     * @return
     */
    int myCommentNum(Long userId);
}
