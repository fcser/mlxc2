package com.jxxy.mlxc.business.util;

import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.service.GrabSimgleService;
import com.jxxy.mlxc.business.api.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Project:mlxc-parent
 * @Class:ProductUpdate
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日9:34
 * @Description:定时任务，每天固定时间更新抢单商品
 * @Version: 1.0.0
 */
@Component
@ConditionalOnProperty(prefix = "mlxc", name = "isSeckill", havingValue = "true")
@Configuration
@Slf4j
public class ProductUpdate {

    @Autowired
    private GrabSimgleService grabSimgleService;
    @Autowired
    private ProductService productService;
    //每天上午十一点秒杀开始,更新秒杀数据库
    @Scheduled(cron="0 0 11 * * ?  ")
    public void insertSeckill(){
        int i=0;
        int n=0;
        GrabSimgleDto grabSimgleDto=grabSimgleService.getGrabSimgle();
        while(i<3&&n!=0){
            n=productService.insertSeckill(grabSimgleDto);
            i++;
        }
    }
}
