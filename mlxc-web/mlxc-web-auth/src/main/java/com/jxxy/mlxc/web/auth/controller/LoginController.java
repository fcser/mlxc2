/**
 * 
 */
package com.jxxy.mlxc.web.auth.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/beautifulcountry")
public class LoginController {

	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Reference(version="1.0.0")
	private UserService userService;
	
	/**
	 * 
	 *@param:
	 *@return:Object
	 *@throws:
	 *@deprecated:
	 *
	 */
	@PostMapping(value="/login.do")
	@ResponseBody
	public Object login(@RequestParam(value="phone",required=true)String phone,
			@RequestParam(value="password",required=true)String password) {
		logger.info("---"+phone+"的用户开始登录----");
		//String password="123456";
		BaseReturnDto<UserDto> brd=null;
		UsernamePasswordToken token=null;//new UsernamePasswordToken(phone,password);
		Subject currentUser=SecurityUtils.getSubject();
		//判断是否已经认定
		if(!currentUser.isAuthenticated()) {
			logger.info("消息认证"+currentUser.getSession().getId());
			token=new UsernamePasswordToken(phone,password);
			try {
				currentUser.login(token);
				UserDto user=userService.getUserByPhone(phone);
				currentUser.getSession().setAttribute(LoginCode.LOGIN_NAME, user.getUserName());
				currentUser.getSession().setAttribute(LoginCode.LOGIN_ID, user.getId());
				currentUser.getSession().setAttribute(LoginCode.LOGIN_PHONE, phone);
				currentUser.getSession().setAttribute(LoginCode.LOGIN_ROLE, user.getRole());
				brd=new BaseReturnDto<UserDto>(0,"登录成功");
			}catch (UnknownAccountException e) {
				logger.error(String.format("user not found: %s", phone), e);
				brd=new BaseReturnDto<UserDto>();
				brd.setCode(-1);
				brd.setMsg("登录失败,未知账号");
			} catch(IncorrectCredentialsException e) {
				logger.error(String.format("user: %s pwd: %s error", phone, password), e);
				brd=new BaseReturnDto<UserDto>();
				brd.setCode(-1);
				brd.setMsg("登录失败，密码错误");
			}catch (LockedAccountException e) {
				logger.error(String.format("user has been authenticated: %s", phone), e);
				brd=new BaseReturnDto<UserDto>();
				brd.setCode(-1);
				brd.setMsg("登录失败，用户被锁定");
			} catch (AuthenticationException e) {
				logger.error(String.format("account except: %s", phone), e);
				brd=new BaseReturnDto<UserDto>();
				brd.setCode(-1);
				brd.setMsg("登录失败，未知原因");
			}
		}else {
			brd=new BaseReturnDto<UserDto>(-1,"用户已登录");
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
	@GetMapping("/logout.do")
	public Object logout() {
		Subject currentUser=SecurityUtils.getSubject();
		currentUser.logout();
		return null;
	}

	
}
