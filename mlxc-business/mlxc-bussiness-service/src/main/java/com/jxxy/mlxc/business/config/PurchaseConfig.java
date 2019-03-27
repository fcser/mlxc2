package com.jxxy.mlxc.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Project:mlxc-parent
 * @Class:PurchaseConfig
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月27日10:47
 * @Description:抢单业务配置
 * @Version: 1.0.0
 */
@Configuration
public class PurchaseConfig {
    private static boolean isVerifyUser;

    @Value("${mlxc.isVerifyUser}")
    public void setIsVerifyUser(boolean isVerifyUser){
        this.isVerifyUser=isVerifyUser;
    }

    public static boolean getIsVerifyUser(){
        return isVerifyUser;
    }
}
