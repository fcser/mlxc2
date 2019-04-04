package com.jxxy.mlxc.news.service.impl;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.CommentDependencyDto;
import com.jxxy.mlxc.news.api.dto.CommentDto;
import com.jxxy.mlxc.news.api.dto.MyCommentsDto;
import com.jxxy.mlxc.news.api.query.CommentQuery;
import com.jxxy.mlxc.news.api.service.CommentService;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CommentServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日16:09
 * @Description:留言板块业务逻辑
 * @Version: 1.0.0
 */

public class CommentServiceImpl implements CommentService {
    @Override
    public void insert(CommentDto commentDto) {

    }

    @Override
    public void giveALike() {

    }

    @Override
    public Integer countComments() {
        return null;
    }

    @Override
    public List<CommentDependencyDto> getComments(Long newsId) {
        return null;
    }

    @Override
    public PageInfo<MyCommentsDto> getMyComments(CommentQuery commentQuery) {
        return null;
    }
}
