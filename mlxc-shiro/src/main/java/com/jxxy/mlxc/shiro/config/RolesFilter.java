package com.jxxy.mlxc.shiro.config;

import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import com.mlxc.basic.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @Project:mlxc-parent
 * @Class:RolesFilter
 * @author:zhouyangmin
 * @CreateTime:2019年03月28日16:20
 * @Description:角色过滤器
 * @Version: 1.0.0
 */
@Slf4j
public class RolesFilter extends RolesAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response,
                                     Object mappedValue) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        BaseReturnDto<Void> brd = new BaseReturnDto<>(ReturnCode.FAIL_ROLE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().print(JsonUtil.bean2json(brd));
        return Boolean.FALSE;
    }
}
