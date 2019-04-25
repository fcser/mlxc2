package com.jxxy.mlxc.news.controller;
import com.jxxy.mlxc.news.utils.ActiveRemindTool;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Project:mlxc-news-service
 * @Class:NewsController.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午8:06:52
 * @Description:
 * @Version: 1.0.0
 **/


@Controller
public class NewsController {


	@GetMapping("/addHour.do")
	@ResponseBody
	public Object addNews() {
        return new BaseReturnDto<>(ReturnCode.SUCCESS, ActiveRemindTool.getBeforeHour());
	}
}
