package com.jxxy.mlxc.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.service.SeckillService;
import com.jxxy.mlxc.business.config.PurchaseConfig;
import com.jxxy.mlxc.business.mapper.ProductDao;
import com.jxxy.mlxc.business.mapper.PurchaseRecordDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Project:mlxc-parent
 * @Class:SeckillServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日13:31
 * @Description:秒杀操作服务
 * @Version: 1.0.0
 * 说明：插入秒杀库中，并不立即减少库存，确保秒杀库正常
 * 存在的问题：秒杀商品数量，是否需要先从库存中减去
 */
@Service(version="1.0.0",interfaceClass= SeckillService.class)
@Component
@Transactional(rollbackFor=Exception.class)
@Slf4j
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao;
    @Override
    public int insertSeckill(GrabSimgleDto grabSimgleDto) {
        if(productDao.getProduct(grabSimgleDto.getProductId()).getStock()<grabSimgleDto.getCount()){
            return 0;
        }
        return productDao.insertSeckill(grabSimgleDto);
    }

    @Override
    public boolean sckkill(PurchaseRecordDto dto) {
        //乐观锁解决方案,缺陷，多次数据库io操作，性能开销较大
        //检查用户有没有已经抢购了
        if(PurchaseConfig.getIsVerifyUser()&&purchaseRecordDao.countRecords(dto.getUserId(),dto.getProductId())>0){
            log.info("用户：{}，重复下单",dto.getUserId());
            return false;
        }
        //下     单
        long start=System.currentTimeMillis();
        while(true){
            long end=System.currentTimeMillis();
            if(end-start>100)
                return false;
            ProductDto productDto=productDao.getProduct(dto.getProductId());
            if(productDto.getSeckillNum()<2||productDto.getStock()<2){
                //库存不足
                return false;
            }
            //减库存
            int result=productDao.seckill(dto.getProductId(),productDto.getVersion());
            if(result==0)
                continue;
            //插入购买记录
            purchaseRecordDao.insertPurchaseRecord(dto);
            return true;
        }
    }
}
