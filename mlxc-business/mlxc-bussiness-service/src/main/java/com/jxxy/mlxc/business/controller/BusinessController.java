/**
 * 
 */
package com.jxxy.mlxc.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxxy.mlxc.business.service.BusinessService;

/**
 * @Project:mlxc-bussiness-service
 * @Class:BusinessController.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月21日上午9:46:02
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Controller
public class BusinessController {

	@Autowired
	//@Qualifier("businessServiceImpl")
	BusinessService businessService;
	
	@GetMapping("hi.do")
	@ResponseBody
	public String sayHi() {
		businessService.sayHi();
		return "ok";
	}
}
