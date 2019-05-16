package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.query.RecordsQuery;
import com.jxxy.mlxc.business.api.service.RecordsService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:PurchaseController
 * @author:zhouyangmin
 * @CreateTime:2019年04月28日20:15
 * @Description:抢单控制器
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/mlxc")
public class PurchaseController {

    @Reference(version="1.0.0")
    private RecordsService recordsService;
    /**
     * 抢单业务
     * @param productId
     * @param num 购买数量
     * @return
     */
    @PostMapping("/desk/grab.do")
    @ResponseBody
    public Object grabASingle(@RequestParam("productId") Long productId,
                              @RequestParam("num")Integer num){
        Long userId= AuthUtil.getUserId();
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 购买门票
     * @return
     */
    @PostMapping("/desk/buy.do")
    @ResponseBody
    public Object buy(@RequestBody PurchaseRecordDto purchaseRecordDto){
        purchaseRecordDto.setUserId(AuthUtil.getUserId());
        purchaseRecordDto.setIsSeckill(0);
        return new BaseReturnDto<>(ReturnCode.SUCCESS,recordsService.purchase(purchaseRecordDto));
    }

    /**
     * 获取我的订单
     * @return
     */
    @GetMapping("/desk/myProduct.do")
    @ResponseBody
    public Object myProduct(@ModelAttribute RecordsQuery query){
        query.setUserId( AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,recordsService.showMyRecords(query));
    }
    @GetMapping("/manage/business/records.do")
    @ResponseBody
    public Object getRecords(@ModelAttribute RecordsQuery query){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,recordsService.showAllRecords(query));
    }
}
