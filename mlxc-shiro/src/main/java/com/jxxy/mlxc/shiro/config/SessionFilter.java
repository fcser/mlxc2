/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

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
public class SessionFilter extends UserFilter {

	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse resp=(HttpServletResponse) response;
		BaseReturnDto<Void> brd=new BaseReturnDto<>(ReturnCode.FAIL_TIME_OUT.getCode(),"please login again!");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		resp.getWriter().print(JsonUtil.bean2json(brd));
		return false;
	}
}
