package com.jxxy.mlxc.news.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.CommentDependencyDto;
import com.jxxy.mlxc.news.api.dto.CommentDto;
import com.jxxy.mlxc.news.api.dto.MyCommentsDto;
import com.jxxy.mlxc.news.api.model.CommentDO;
import com.jxxy.mlxc.news.api.model.CommentDependDO;
import com.jxxy.mlxc.news.api.query.CommentQuery;
import com.jxxy.mlxc.news.api.service.CommentService;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.news.converter.CommentConverter;
import com.jxxy.mlxc.news.mapper.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CommentServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日16:09
 * @Description:留言板块业务逻辑
 * @Version: 1.0.0
 */
@Service(version="1.0.0",interfaceClass= CommentService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private CommentConverter commentConverter;
    @Override
    public void insert(CommentDto commentDto) {
        CommentDO commentDO=commentConverter.toCommentDO(commentDto);
        commentDAO.insert(commentDO);
        //子评论插入依赖
        if(commentDto.getFatherCommentId()!=null&&commentDto.getFatherCommentId()>0){
            //子评论
            CommentDependDO commentDependDO=commentConverter.toCommentDependDO(commentDto);
            commentDAO.insertDependency(commentDependDO);
        }
    }

    @Override
    public boolean isGiveLike(Long id, Long userId) {
        return commentDAO.getMyLike(id,userId)>0?true:false;
    }

    @Override
    public void giveALike(Long id,Long userId){
        commentDAO.insetGood(id, userId);
        commentDAO.updateGoods(id);
    }
    @Override
    public Integer countComments(Long newsId) {
        return commentDAO.countComments(newsId);
    }

    @Override
    public List<CommentDependencyDto> getComments(Long newsId) {
        return commentDAO.getComments(newsId);
    }

    @Override
    public PageInfo<MyCommentsDto> getMyComments(CommentQuery commentQuery) {
        PageHelper.startPage(commentQuery.getPageNum(),commentQuery.getPageSize());
        List<MyCommentsDto> list=commentDAO.getMyComments(commentQuery);
        return new PageInfo<>(list);
    }

}
