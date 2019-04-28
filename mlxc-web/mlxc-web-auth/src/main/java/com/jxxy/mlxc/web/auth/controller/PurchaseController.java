package com.jxxy.mlxc.web.auth.controller;

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
@RequestMapping("/mlxc/desk")
public class PurchaseController {

    /**
     * 抢单业务
     * @param productId
     * @param num 购买数量
     * @return
     */
    @PostMapping("/grab.do")
    @ResponseBody
    public Object grabASingle(@RequestParam("productId") Long productId,
                              @RequestParam("num")Integer num){
        Long userId= AuthUtil.getUserId();
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 购买门票
     * @param productId
     * @param num
     * @return
     */
    @PostMapping("/buy.do")
    @ResponseBody
    public Object buy(@RequestParam("productId") Long productId,
    @RequestParam("num")Integer num){
        Long userId= AuthUtil.getUserId();
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 获取我的订单
     * @return
     */
    @GetMapping("/myProduct.do")
    @ResponseBody
    public Object myProduct(){
        Long userId= AuthUtil.getUserId();
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
}
