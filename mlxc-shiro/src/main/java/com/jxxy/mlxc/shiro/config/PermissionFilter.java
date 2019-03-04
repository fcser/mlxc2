/**
 * 
 *//*
package com.jxxy.mlxc.shiro.config;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import com.mlxc.basic.util.JsonUtil;

*//**
 * @Project:mlxc-shiro
 * @Class:PermissionFilter.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月1日下午8:34:36
 * @Description:
 * @Version: 1.0.0 
 *
 *//*
public class PermissionFilter extends PermissionsAuthorizationFilter {

    private static final Logger logger = LoggerFactory.getLogger(PermissionFilter.class);

	@SuppressWarnings("unused")
	private String prefix;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                   Object mappedValue) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();
        // 判断是否有权限
        boolean isAccess = super.isAccessAllowed(request, response, new String[] { path });
        logger.info("request path:{} isAccess:{}", path, isAccess);

        return isAccess;
    }
    
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response,
                                     Object mappedValue) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        BaseReturnDto<Void> brd = new BaseReturnDto<>(ReturnCode.FAIL_PERMISSION.getCode(),
                                                      "operation is forbidden, please confirm your permission!");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(brd.toString());
        return Boolean.FALSE;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
*/