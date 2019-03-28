/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

/**
 * @Project:mlxc-shiro
 * @Class:MySessionManager.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月1日下午3:25:13
 * @Description:
 * @Version: 1.0.0 
 *
 */
public class MySessionManager extends DefaultWebSessionManager {

	//授权
		private static final String AUTHORIZATION="Authorization";
		
		private static final String REFERENCED_SESSION_ID_RESOURCE="Stateless request";
		
		public MySessionManager() {
			super();
			//sessionid的默认失效时间是30分钟，我们可以更改
			//setGlobalSessionTimeout();
		}
		
		/**
		 * 重写获取sessionid的方式，前后端分离可能不会带有cookie
		 */
		@Override
		protected Serializable getSessionId(ServletRequest request,ServletResponse response) {
			String id=WebUtils.toHttp(request).getHeader(AUTHORIZATION);
			//若请求头中有Authoriation，则其值为sessionid
			if(!StringUtils.isEmpty(id)) {
				request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_RESOURCE);
				request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
				request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
				return id;
			}else {
				return super.getSessionId(request, response);
			}
		}
}
