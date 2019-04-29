/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.UserFilter;

import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import com.mlxc.basic.util.JsonUtil;

/**
 * @project: beautifulcountry
 * @class: SessionFilter
 * @author: zhouyangmin
 * @createDate: 2019年1月8日 下午2:54:13
 * @description: 处理session超时及未登录异常
 * @version: v1.0
 */
@Slf4j
public class SessionFilter extends UserFilter {

	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpServletRequest request1=(HttpServletRequest) request;
		BaseReturnDto<Void> brd=new BaseReturnDto<>(ReturnCode.FAIL_TIME_OUT.getCode(),"please login again!");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		log.info("please login again");
		/*resp.setHeader("Access-Control-Allow-Origin", request1.getHeader("Origin"));
		//允许客户端发送cookie，true表示接收
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setHeader("P3P", "CP=CAO PSA OUR");
		if(request1.getHeader("Access-Control-Request-Method")!=null&&"OPTIONS".equals(request1.getMethod())) {
			resp.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS,PUT,DELETE");
			resp.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
			resp.addHeader("Access-Control-Max-Age", "120");
		}*/
		resp.getWriter().print(JsonUtil.bean2json(brd));
		return false;
	}
}
