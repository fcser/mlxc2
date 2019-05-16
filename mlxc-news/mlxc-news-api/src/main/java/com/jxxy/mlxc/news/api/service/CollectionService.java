package com.jxxy.mlxc.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.CollectionDto;
import com.jxxy.mlxc.news.api.query.CollectionQuery;

/**
 * @Project:mlxc-parent
 * @Class:CollectionService
 * @author:zhouyangmin
 * @CreateTime:2019年04月18日13:09
 * @Description:收藏服务
 * @Version: 1.0.0
 */

public interface CollectionService {
    /**
     * 是否已经收藏
     * @param userId
     * @return
     */
    int isCollected(Long userId,Long newsId);

    /**
     * 查看收藏数量
     * @param newsId
     * @return
     */
    int countCollect(Long newsId);
    /**
     * 收藏文章
     * @param userId
     * @param newsId
     */
    void collect(Long userId,Long newsId);

    /**
     * 分页查询我收藏的文章
     * @param collectionQuery
     * @return
     */
    PageInfo<CollectionDto> getMyCollection(CollectionQuery collectionQuery);
}
