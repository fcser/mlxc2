package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.jxxy.mlxc.auth.api.service.UserService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import com.mlxc.basic.util.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:UserController
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月30日15:53
 * @Description:用户注册
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/mlxc")
@Slf4j
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    @PostMapping("/regist.do")
    @ResponseBody
    public Object regist(@RequestBody UserDto user) {
        userService.insert(user);
        return new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"注册成功");
    }

    /**
     * 验证手机有消息
     * @param phone
     * @return
     */
    @GetMapping("/canRegist.do")
    @ResponseBody
    public Object canRegist(@RequestParam(value="phone") String phone) {
        BaseReturnDto<String> brd=null;
        UserDto user=userService.getUserByPhone(phone);
        if(user==null) {
            String msg=	SmsUtil.execute(phone, 60);
            //String msg="123456";
            brd=new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"检查手机号成功！");
            brd.setData(msg);
        }else {
            brd=new BaseReturnDto<>(1,"该手机号已被注册！");
        }
        return brd;
    }
    @PostMapping("/update.do")
    @ResponseBody
    public Object update(@RequestBody UserDto user) {
        BaseReturnDto<String> brd=null;
        int i=userService.update(user);
        brd=new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"修改资料成功！");
        return brd;
    }
    @GetMapping("/getUserByid.do")
    @ResponseBody
    public Object getUser(){
        Long id= AuthUtil.getUserId();
        return new BaseReturnDto<>(ReturnCode.SUCCESS,userService.select(id));
    }
}
