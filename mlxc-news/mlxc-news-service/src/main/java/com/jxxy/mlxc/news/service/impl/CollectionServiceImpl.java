package com.jxxy.mlxc.news.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.CollectionDto;
import com.jxxy.mlxc.news.api.query.CollectionQuery;
import com.jxxy.mlxc.news.api.service.CollectionService;
import com.jxxy.mlxc.news.mapper.CollectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CollectionServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年04月18日14:04
 * @Description:
 * @Version: 1.0.0
 */
@Service(version="1.0.0",interfaceClass= CollectionService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class CollectionServiceImpl implements CollectionService{

    @Autowired
    private CollectionDAO collectionDAO;


    @Override
    public int isCollected(Long userId, Long newsId) {
        return collectionDAO.countMyCollect(userId,newsId);
    }

    @Override
    public int countCollect(Long newsId) {
        return collectionDAO.countCollect(newsId);
    }

    @Override
    public void collect(Long userId, Long newsId) {
        collectionDAO.insert(userId,newsId);
    }

    @Override
    public PageInfo<CollectionDto> getMyCollection(CollectionQuery collectionQuery) {
        PageHelper.startPage(collectionQuery.getPageNum(),collectionQuery.getPageSize());
        List<CollectionDto> list=collectionDAO.getMyCollect(collectionQuery.getUserId());
        return new PageInfo<>(list);
    }
}
