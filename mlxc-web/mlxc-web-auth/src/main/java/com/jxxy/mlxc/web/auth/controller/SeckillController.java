package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.business.api.dto.GrabSimgleDto;
import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.service.SeckillService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:SeckillController
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日15:04
 * @Description:秒杀控制器
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/mlxc")
public class SeckillController {
    @Reference(version="1.0.0")
    private SeckillService seckillService;
    /**
     * 新增抢单活动
     * @param grabSimgleDto
     * @return
     */
    @PostMapping("/manage/business/addSeckill.do")
    @ResponseBody
    public Object add(@RequestBody GrabSimgleDto grabSimgleDto){
        grabSimgleDto.setCreateUserId(AuthUtil.getUserId());
        seckillService.add(grabSimgleDto);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    @PostMapping("/manage/business/upSeckill.do")
    @ResponseBody
    public Object update(@RequestBody GrabSimgleDto grabSimgleDto){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @DeleteMapping("/manage/business/delSeckill.do")
    @ResponseBody
    public Object del(@RequestBody GrabSimgleDto grabSimgleDto){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 秒杀接口
     * @return
     */
    @PostMapping("/desk/seckill.do")
    @ResponseBody
    public Object seckill(@RequestBody PurchaseRecordDto dto){
        dto.setUserId(AuthUtil.getUserId());
        if(seckillService.sckkill(dto)) {
            return new BaseReturnDto<>(ReturnCode.SUCCESS);
        }else{
            return new BaseReturnDto<>(-1,"抱歉，商品已售完");
        }
    }
}
