package com.jxxy.mlxc.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.dto.RecordsDto;
import com.jxxy.mlxc.business.api.query.RecordsQuery;
import com.jxxy.mlxc.business.api.service.RecordsService;
import com.jxxy.mlxc.business.config.PurchaseConfig;
import com.jxxy.mlxc.business.mapper.ProductDao;
import com.jxxy.mlxc.business.mapper.PurchaseRecordDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:PruchaseRecordServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年03月26日21:50
 * @Description:订单业务
 * @Version: 1.0.0
 */
@Service(version="1.0.0",interfaceClass=RecordsService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class PruchaseRecordServiceImpl implements RecordsService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao;
    @Override
    public PageInfo<RecordsDto> listRecords(RecordsQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<RecordsDto> list=purchaseRecordDao.listRecords(query);
        return new PageInfo<>(list);
    }

    @Override
    public boolean purchase(PurchaseRecordDto dto) {
        //乐观锁解决方案,缺陷，多次数据库io操作，性能开销较大
        //检查用户有没有已经购买了
        //下     单
        long start=System.currentTimeMillis();
        long end=System.currentTimeMillis();
        if(end-start>100)
            return false;
        ProductDto productDto=productDao.getProduct(dto.getProductId());
        if(productDto.getStock()<dto.getCount()){
            //库存不足
            return false;
        }
        //减库存
        int result=productDao.decreaseProduct(dto.getProductId(),dto.getCount());
        Double sum=dto.getPrice()*dto.getCount();
        dto.setSum(sum);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(dto);
        return true;
    }

    @Override
    public PageInfo<RecordsDto> showMyRecords(RecordsQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<RecordsDto> list=purchaseRecordDao.showMyRecords(query);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<RecordsDto> showAllRecords(RecordsQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<RecordsDto> list=purchaseRecordDao.listRecords(query);
        return new PageInfo<>(list);
    }
}
