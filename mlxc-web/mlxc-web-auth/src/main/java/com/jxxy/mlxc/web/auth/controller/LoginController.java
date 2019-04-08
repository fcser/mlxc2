/**
 * 
 */
package com.jxxy.mlxc.web.auth.controller;

import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.jxxy.mlxc.shiro.config.ShiroProperties;
import com.mlxc.basic.constant.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.auth.api.dto.UserDto;
import com.jxxy.mlxc.auth.api.service.UserService;
import com.mlxc.basic.constant.LoginCode;
import com.mlxc.basic.dto.BaseReturnDto;



/**
 * @project: beautifulcountry
 * @class: LoginController
 * @author: zhouyangmin
 * @createDate: 2019年1月8日 下午3:42:21
 * @description: 
 * @version: v1.0
 */
@Controller
//@RequestMapping("/mlxc")
@Slf4j
public class LoginController {

	@Reference(version="1.0.0",url="dubbo://127.0.0.1:20880")
	private UserService userService;
	
	/**
	 * 
	 *@param:
	 *@return:Object
	 *@throws:
	 *@deprecated:
	 *
	 */
	@PostMapping(value="/mlxc/login.do")
	@ResponseBody
	public Object login(@RequestParam(value="phone",required=true)String phone,
			@RequestParam(value="password",required=true)String password) {
		log.info("---"+phone+"的用户开始登录----");
		BaseReturnDto<UserDto> brd=null;
		UsernamePasswordToken token=null;//new UsernamePasswordToken(phone,password);
		Subject currentUser=SecurityUtils.getSubject();
		//判断是否已经认定
		if(!currentUser.isAuthenticated()) {
			log.info("消息认证"+currentUser.getSession().getId());
			token=new UsernamePasswordToken(phone,password);
			try {
				currentUser.login(token);
				UserDto user=userService.getUserByPhone(phone);
				AuthUtil.setUser(user);
				user.setPassword(null);
				brd=new BaseReturnDto<>(ReturnCode.SUCCESS,user);
			}catch (UnknownAccountException e) {
				brd=new BaseReturnDto<>(ReturnCode.FAIL_LOGIN.getCode(),"登录失败,未知账号");
			} catch(IncorrectCredentialsException e) {
				brd=new BaseReturnDto<>(ReturnCode.FAIL_LOGIN.getCode(),"登录失败，密码错误");
			}catch (LockedAccountException e) {
				brd=new BaseReturnDto<>(ReturnCode.FAIL_LOGIN.getCode(),"登录失败，用户被锁定");
			} catch (AuthenticationException e) {
				brd=new BaseReturnDto<>(ReturnCode.FAIL_LOGIN.getCode(),"登录失败，未知原因");
			}
		}else {
			brd=new BaseReturnDto<>(ReturnCode.FAIL_LOGIN.getCode(),"用户已登录");
		}
		return brd;
	}
	/**
	 * 
	 *@param:
	 *@return:Object
	 *@throws:
	 *@deprecated:
	 *
	 */
	@PostMapping("/mlxc/logout.do")
	@ResponseBody
	public Object logout() {
		Subject currentUser=SecurityUtils.getSubject();
		currentUser.logout();
		return new BaseReturnDto<>(ReturnCode.SUCCESS,"系统退出成功");
	}
	@GetMapping("/mlxc/desk/user.do")
	@ResponseBody
	public Object getUser(){
		log.info("auth:{}", ShiroProperties.getAuthFilter());
		UserDto user=AuthUtil.getUser();
		log.info("user:{}",user.toString());
		return new BaseReturnDto<>(ReturnCode.SUCCESS,user);
	}
	@GetMapping("/mlxc/manage/admin.do")
	@ResponseBody
	public Object getAdmin(){
		return new BaseReturnDto<>(0,"success");
	}
	@GetMapping("/mlxc/manage/business/business.do")
	@ResponseBody
	public Object getBusiness(){
		return new BaseReturnDto<>(0,"success");
	}

	/**
	 * 未登录
	 * @return
	 */
	@GetMapping("/mlxc/noLogin.do")
	@ResponseBody
	public Object noLonging(){
		return new BaseReturnDto<>(ReturnCode.FAIL_NOT_LOGIN);
	}

	/**
	 * 无权限
	 * @return
	 */
	@GetMapping("/mlxc/noRoles.do")
	@ResponseBody
	public Object noRoles(){
		return new BaseReturnDto<>(ReturnCode.FAIL_ROLE);
	}
}
