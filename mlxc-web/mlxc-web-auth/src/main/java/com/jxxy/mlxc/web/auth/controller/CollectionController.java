package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.news.api.query.CollectionQuery;
import com.jxxy.mlxc.news.api.service.CollectionService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:CollectionController
 * @author:zhouyangmin
 * @CreateTime:2019年04月18日14:12
 * @Description:
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/mlxc/desk")
public class CollectionController {
    @Reference(version = "1.0.0")
    private CollectionService collectionService;
    @PostMapping("/collect.do")
    @ResponseBody
    public Object collect(@RequestParam("newsId") Long newsId){
        Long userId= AuthUtil.getUserId();
        if(collectionService.isCollected(userId,newsId)>0){
            //文章已被收藏
            return new BaseReturnDto<>(ReturnCode.REPEAT.getCode(),"您已收藏过此文章");
        }
        collectionService.collect(userId,newsId);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @GetMapping("/myCollection.do")
    @ResponseBody
    public Object getMyCollect(@ModelAttribute CollectionQuery collectionQuery){
        collectionQuery.setUserId(AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,collectionService.getMyCollection(collectionQuery));
    }
}
