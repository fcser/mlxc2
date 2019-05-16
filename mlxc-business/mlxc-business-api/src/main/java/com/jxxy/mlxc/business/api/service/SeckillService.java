package com.jxxy.mlxc.business.api.service;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;

/**
 * @Project:mlxc-parent
 * @Class:SeckillService
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日13:26
 * @Description:秒杀服务
 * @Version: 1.0.0
 */

public interface SeckillService {

    /**
     * 插入秒杀活动
     *
     * @param grabSimgleDto
     * @return
     */
    int insertSeckill(GrabSimgleDto grabSimgleDto);

    /**
     * 新增秒杀
     * @param grabSimgleDto
     * @return
     */
    void add(GrabSimgleDto grabSimgleDto);
    /**
     * 抢单服务
     *
     * @param purchaseRecordDto
     * @return
     */
    boolean sckkill(PurchaseRecordDto purchaseRecordDto);


}