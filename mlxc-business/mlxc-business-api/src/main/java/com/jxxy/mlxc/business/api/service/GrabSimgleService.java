package com.jxxy.mlxc.business.api.service;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;

/**
 * @Project:mlxc-parent
 * @Class:GrabSimgleService
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日9:46
 * @Description:抢单服务
 * @Version: 1.0.0
 */

public interface GrabSimgleService {
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
}
