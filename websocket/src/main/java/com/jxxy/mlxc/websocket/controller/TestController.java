package com.jxxy.mlxc.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project:mlxc-parent
 * @Class:TestController
 * @author:zhouyangmin
 * @CreateTime:2019年05月15日20:08
 * @Description:
 * @Version: 1.0.0
 */
@Controller
@Slf4j
public class TestController {
    @GetMapping("/do")
    @ResponseBody
    public String open(){
        log.info("点击测试");
        return "a";
    }
}
