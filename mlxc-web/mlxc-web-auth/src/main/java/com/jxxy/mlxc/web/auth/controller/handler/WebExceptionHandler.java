package com.jxxy.mlxc.web.auth.controller.handler;

/**
 * @Project:mlxc-parent
 * @Class:WebExceptionHandeler
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月28日18:43
 * @Description:web错误全局处理器
 * @Version: 1.0.0
 */

import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@Slf4j
public class WebExceptionHandler {


    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败：",e);
        BaseReturnDto<String> brd=new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM.getCode(),"参数解析失败");
        return brd;
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法：",e);
        BaseReturnDto<String> brd=new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM.getCode(),"不支持当前请求方法");
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
        BaseReturnDto<String> brd=new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM.getCode(),"参数类型不匹配");
        return brd;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        log.error("服务器运行异常:",e);
        BaseReturnDto<String> brd=new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM);
        return brd;
    }
}

