/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import com.jxxy.mlxc.auth.api.dto.UserDto;
import org.apache.shiro.SecurityUtils;

/**
 * @Project:mlxc-shiro
 * @Class:AuthUtil.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日下午9:07:18
 * @Description:shiro工具类
 * @Version: 1.0.0 
 *
 */
public class AuthUtil {

    public static final String SESSION_USER="session_user";

    public static UserDto getUser(){
        return (UserDto) SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER);
    }

    public static void setUser(UserDto userDto){
        SecurityUtils.getSubject().getSession().setAttribute(SESSION_USER,userDto);
    }

    public static Long getUserId(){
        //开发者者模式，不开启shiro
        if(!ShiroProperties.getIsOpen()){
            return 1l;
        }
        return getUser()==null?0l:getUser().getId();
    }
}
