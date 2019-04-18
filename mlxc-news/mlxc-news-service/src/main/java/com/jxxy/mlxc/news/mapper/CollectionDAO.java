package com.jxxy.mlxc.news.mapper;

import com.jxxy.mlxc.news.api.dto.CollectionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:CollectionDAO
 * @author:zhouyangmin
 * @CreateTime:2019年04月11日21:44
 * @Description:收藏mapper
 * @Version: 1.0.0
 */
@Mapper
public interface CollectionDAO {
    /**
     * 插入收藏
     * @param userId
     * @param newsId
     * @return
     */
    int insert(@Param("userId")Long userId, @Param("newsId")Long newsId);

    /**
     * 是否已经收藏
     * @param userId
     * @param newsId
     * @return
     */
    int countMyCollect(@Param("userId")Long userId, @Param("newsId")Long newsId);

    /**
     * 查询我所有收藏的文章
     * @param userId
     * @return
     */
    List<CollectionDto> getMyCollect(Long userId);
}
