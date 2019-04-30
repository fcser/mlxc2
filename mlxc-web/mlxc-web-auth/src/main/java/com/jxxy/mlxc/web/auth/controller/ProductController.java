package com.jxxy.mlxc.web.auth.controller;

import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 获取产品列表,主页只显示最新商品
     * @return
     */
    @GetMapping("/productList.do")
    @ResponseBody
    public Object getProducts(){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 商品id
     * @param id
     * @return
     */
    @GetMapping("/product.do")
    @ResponseBody
    public Object getProduct(@RequestParam("id")Long id) {
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 新增商品
     * @param dto
     * @return
     */
    @PostMapping("/manage/business/addProduct.do")
    @ResponseBody
    public Object add(@RequestBody ProductDto dto){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 修改
     * @param dto
     * @return
     */
    @PostMapping("/manage/business/upProduct.do")
    @ResponseBody
    public Object update(@RequestBody ProductDto dto){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/manage/business/delProduct.do")
    @ResponseBody
    public Object del(@RequestParam("id")Long id){
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

}
