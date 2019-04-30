package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.news.api.dto.ActiveDto;
import com.jxxy.mlxc.news.api.dto.EntryDto;
import com.jxxy.mlxc.news.api.query.ActiveQuery;
import com.jxxy.mlxc.news.api.query.EntryQuery;
import com.jxxy.mlxc.news.api.service.ActiveService;
import com.jxxy.mlxc.news.api.service.EntryService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:ActiveController
 * @author:zhouyangmin
 * @CreateTime:2019年04月07日17:05
 * @Description:活动controller,缺陷，没有审批流
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/mlxc")
public class ActiveController {
    @Reference(version = "1.0.0")
    private ActiveService activeService;
    @Reference(version = "1.0.0")
    private EntryService entryService;
    /**
     * 获取活动详情
     * @return
     */
    @GetMapping("/acitive/get.do")
    @ResponseBody
    public Object getActive(@RequestParam("newsId") Long newsId){
        ActiveDto dto=activeService.selectByNewsId(newsId);
        if(entryService.isEntry(dto.getId(),AuthUtil.getUserId())){
            dto.setIsEntryd(1);
        }
        return new BaseReturnDto<>(ReturnCode.SUCCESS,dto);
    }

    /**
     * 插入活动
     * @param activeDto
     * @return
     */
    @PostMapping("/manage/active/insert.do")
    @ResponseBody
    public Object insertActive(@RequestBody ActiveDto activeDto){
        activeDto.setCreateUserId(AuthUtil.getUserId());
        activeService.insert(activeDto);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 活动报名
     * @param entryDto
     * @return
     */
    @PostMapping("/desk/entry.do")
    @ResponseBody
    public Object enrty(@RequestBody EntryDto entryDto){
        entryDto.setEntryUserId(AuthUtil.getUserId());
        if(entryService.isEntry(entryDto.getActiveId(),entryDto.getEntryUserId())){
            //return new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"你已报名");
            entryService.unEntry(entryDto);
            return new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"取消报名成功");
        }
        entryService.insert(entryDto);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 查看是否已经报名
     * @param activeId
     * @return
     */
    @GetMapping("/desk/isEntry.do")
    @ResponseBody
    public Object isEntry(@RequestParam("activeId") Long activeId){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,entryService.isEntry(activeId,AuthUtil.getUserId()));
    }

    /**
     * 获取活动列表
     * @param activeQuery
     * @return
     */
    @GetMapping("/manage/active/list.do")
    @ResponseBody
    public Object listActives(@ModelAttribute ActiveQuery activeQuery){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,activeService.findActives(activeQuery));
    }

    /**
     * 获取我报名了的活动
     * @param entryQuery
     * @return
     */
    @GetMapping("/desk/active/getMyActives.do")
    @ResponseBody
    public Object getMyActive(@ModelAttribute EntryQuery entryQuery){
        entryQuery.setEntryUserId(AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,entryService.findUserActives(entryQuery));
    }

    /**
     * 获取某活动报名表
     * @param entryQuery
     * @return
     */
    @GetMapping("/manage/entry/listUser.do")
    @ResponseBody
    public Object getEntryList(@ModelAttribute EntryQuery entryQuery){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,entryService.findActiveUsers(entryQuery));
    }

    /**
     * 是否开启短信提醒
     * @param activeId
     * @param openFlag
     * @return
     */
    @GetMapping("/manage/entry/openMsg.do")
    @ResponseBody
    public Object openMsg(@RequestParam(value = "activeId",required = true) Long activeId,
                          @RequestParam(value="openFlag",required = true) int openFlag){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,activeService.openMsg(activeId,openFlag));
    }
}
