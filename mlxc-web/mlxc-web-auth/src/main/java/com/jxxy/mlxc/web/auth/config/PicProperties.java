package com.jxxy.mlxc.web.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Project:mlxc-parent
 * @Class:PicProperties
 * @author:zhouyangmin
 * @CreateTime:2019年04月30日17:04
 * @Description:图片存储路径配置
 * @Version: 1.0.0
 */
@Configuration
public class PicProperties {
    private static String picPath;

    @Value("${mlxc.path.picPath}")
    public void setPicPath(String picPath){
        this.picPath=picPath;
    }
    public static String getPicPath(){
        return picPath;
    }

    private static String imgPath;

    @Value("${mlxc.path.imgPath}")
    public void setImgPath(String imgPath){
        this.imgPath=imgPath;
    }
    public static String getImgPath(){
        return imgPath;
    }

    /**
     * 获取主机ip地址
     * @return
     */
    public static String getLocalAddress(){
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ip;
    }
}
