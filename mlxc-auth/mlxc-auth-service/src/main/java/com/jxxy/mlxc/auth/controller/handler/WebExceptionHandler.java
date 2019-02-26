/**
 * 
 */
package com.jxxy.mlxc.auth.controller.handler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlxc.basic.dto.BaseReturnDto;

import lombok.extern.slf4j.Slf4j;
/**
 * @Project:mlxc-auth-service
 * @Class:WebExceptionHandler.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月22日下午5:07:17
 * @Description:统一异常处理类
 * @Version: 1.0.0 
 *
 */
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

	//private static final Logger logger=LoggerFactory.getLogger(WebExceptionHandler.class);
	
	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		log.error("参数解析失败：",e);
		BaseReturnDto<String> brd=new BaseReturnDto<>(-1,"参数解析失败");
		return brd;
	}
	
	@ResponseBody
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		log.error("不支持当前请求方法：",e);
		BaseReturnDto<String> brd=new BaseReturnDto<>(-1,"不支持当前请求方法");
		return brd;
	}
	
	/*@ResponseBody
	@ExceptionHandler(SQLException.class)
	public Object handleSQLException(SQLException e) {
		logger.error("数据库异常：",e);
		BaseReturnDto<String> brd=new BaseReturnDto<>(-1,"系统异常");
		return brd;
	}*/
	
	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)
	public Object handleIllegalArgumentException(IllegalArgumentException e) {
		log.error("参数类型不匹配:",e);
		BaseReturnDto<String> brd=new BaseReturnDto<>(-1,"参数类型不匹配");
		return brd;
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e) {
		log.error("服务器运行异常:",e);
		BaseReturnDto<String> brd=new BaseReturnDto<>(-1,"服务器运行异常");
		return brd;
	}
}

