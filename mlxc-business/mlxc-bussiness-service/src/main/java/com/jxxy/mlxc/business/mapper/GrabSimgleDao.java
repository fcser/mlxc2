package com.jxxy.mlxc.business.mapper;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Project:mlxc-parent
 * @Class:GrabSimgleDao
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日9:53
 * @Description:抢单列表
 * @Version: 1.0.0
 */
@Mapper
public interface GrabSimgleDao {
    /**
     * 插入抢单
     * @param dto
     */
    void insert(GrabSimgleDto dto);

    /***
     * 修改抢单
     * @param dto
     */
    void update(GrabSimgleDto dto);

    /**
     * 获取抢单列表
     * @return
     */
    GrabSimgleDto getGrabSimgle();
    boolean downSeckill(@Param("id") Long id, @Param("useFlag") Integer useFlag);
}
