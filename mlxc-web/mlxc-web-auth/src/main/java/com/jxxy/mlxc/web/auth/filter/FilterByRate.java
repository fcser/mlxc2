package com.jxxy.mlxc.web.auth.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import com.mlxc.basic.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Project:mlxc-parent
 * @Class:FilterByRate
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日15:10
 * @Description:接口限流,令牌桶思想
 * @Version: 1.0.0
 */
@Component
@WebFilter(filterName="firstFilter",urlPatterns="*.do")
@Slf4j
public class FilterByRate implements Filter {
    //令牌桶思想，
    private final RateLimiter rateLimiter=RateLimiter.create(100);
    private static int MAX_WAIT_TIME=10;
    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
            throws IOException, ServletException {
        HttpServletResponse resp=(HttpServletResponse)response;
        //System.out.println("com in filter");
        //每秒取出一个令牌访问，若10秒未能访问立即返回错误信息，非阻塞
        if(rateLimiter.tryAcquire(1,MAX_WAIT_TIME, TimeUnit.SECONDS)) {
            filter.doFilter(request, response);
        }else {
            log.debug("服务器拒绝了{}的访问",request.getRemoteAddr());
            BaseReturnDto<Void> brd=new BaseReturnDto<>(ReturnCode.FAIL_SYSTEM.getCode(),"请求超时！");
            resp.getWriter().print(JsonUtil.bean2json(brd));
        }
    }



}
