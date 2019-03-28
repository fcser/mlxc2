package com.jxxy.mlxc.shiro.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project:mlxc-parent
 * @Class:NewAuthProperties
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月28日14:35
 * @Description: 新配置文件，解决propertiea加载比bean创建慢的问题
 * @Version: 1.0.0
 */
@Getter
@Setter
@ConfigurationProperties("mlxc.shiro")
@Component
public class NewAuthProperties {
    //private int sessionTime = 1800000;
    private String[] authFilter = {};
    private String[] adminFilter={};
    private String[] noFilter = {};
    private String[] businessFilter={};
    /**未登录跳转地址*/
    private String noLoginUrl="/login.jsp";
    /**未获取角色权限地址*/
    private String noRoleUrl="/error.jsp";
}
