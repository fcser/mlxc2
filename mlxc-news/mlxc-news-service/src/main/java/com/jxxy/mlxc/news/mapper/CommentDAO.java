package com.jxxy.mlxc.news.mapper;

import com.jxxy.mlxc.news.api.dto.CommentDependencyDto;
import com.jxxy.mlxc.news.api.dto.MyCommentsDto;
import com.jxxy.mlxc.news.api.model.CommentDO;
import com.jxxy.mlxc.news.api.model.CommentDependDO;
import com.jxxy.mlxc.news.api.query.CommentQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CommentDAO
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日16:10
 * @Description:留言dao层
 * @Version: 1.0.0
 */
@Mapper
public interface CommentDAO {
    /**
     * 插入留言内容
     * @param comment
     */
    void insert(CommentDO comment);

    /**
     * 插入留言依赖
     * @param commentDependDO
     */
    void insertDependency(CommentDependDO commentDependDO);

    /**
     * 插入点赞信息
     * @param commentId
     * @param userId
     */
    void insetGood(@Param("commentId")Long commentId,@Param("userId") Long userId);

    /**
     * 查看该评论我是否点赞
     * @param commentId
     * @param userId
     * @return
     */
    int getMyLike(@Param("commentId")Long commentId,@Param("userId") Long userId);
    /**
     * 修改点赞量
     */
    void updateGoods(Long id);
    /**
     * 查看一级评论总数
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
     * 查询子评论
     * @param id 父评论id
     * @return
     */
    List<CommentDependencyDto> showChildComments(Long id);

    /**
     * 查询给我的新闻评论（逻辑分，给文章作者）,作者回复如何查看
     * @param commentQuery
     * @return
     */
    List<MyCommentsDto> getMyComments(CommentQuery commentQuery);


}
