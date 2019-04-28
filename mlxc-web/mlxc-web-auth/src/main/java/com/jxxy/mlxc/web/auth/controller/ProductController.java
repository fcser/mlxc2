package com.jxxy.mlxc.web.auth.controller;

import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project:mlxc-parent
 * @Class:ProductController
 * @author:zhouyangmin
 * @CreateTime:2019年04月28日20:01
 * @Description:产品控制器
 * @Version: 1.0.0
 */
@RequestMapping("/mlxc")
@Controller
public class ProductController {
    /**
     * 获取产品列表
     * @return
     */
    @GetMapping("/productList.do")
    @ResponseBody
    public Object getProduct(){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
}
