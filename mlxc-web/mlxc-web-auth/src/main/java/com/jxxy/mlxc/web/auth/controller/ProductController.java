package com.jxxy.mlxc.web.auth.controller;

import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.jxxy.mlxc.business.api.query.ProductQuery;
import com.jxxy.mlxc.business.api.service.ProductService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import jdk.nashorn.internal.ir.annotations.Reference;
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

    @com.alibaba.dubbo.config.annotation.Reference(version = "1.0.0")
    private ProductService productService;
    /**
     * 获取产品列表,主页只显示最新商品
     * @return
     */
    @GetMapping("/productList.do")
    @ResponseBody
    public Object getProducts(){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,productService.showProduct());
    }

    /**
     * 商品id
     * @param id
     * @return
     */
    @GetMapping("/product.do")
    @ResponseBody
    public Object getProduct(@RequestParam("id")Long id) {
        return new BaseReturnDto<>(ReturnCode.SUCCESS,productService.getProductById(id));
    }

    /**
     * 新增商品
     * @param dto
     * @return
     */
    @PostMapping("/manage/business/addProduct.do")
    @ResponseBody
    public Object add(@RequestBody ProductDto dto){
        dto.setCreateUserId(AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,productService.add(dto));
    }

    /**
     * 修改
     * @param dto
     * @return
     */
    @PostMapping("/manage/business/upProduct.do")
    @ResponseBody
    public Object update(@RequestBody ProductDto dto){
        productService.update(dto);
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
        productService.delete(id);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    @GetMapping("/manage/business/list.do")
    @ResponseBody
    public Object listAll(@ModelAttribute ProductQuery query){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,productService.listProduct(query));
    }
}
