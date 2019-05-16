package com.jxxy.mlxc.web.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

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
        return "129.204.56.246";
        /*try{
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> addrs;
            while (networks.hasMoreElements())
            {
                addrs = networks.nextElement().getInetAddresses();
                while (addrs.hasMoreElements())
                {
                    ip = addrs.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && ip.isSiteLocalAddress())
                    {
                        return ip.getHostAddress();
                    }
                }
            }

            // 如果没有外网IP，就返回内网IP
            return "129.204.56.246";
        } catch(Exception e){
            throw new RuntimeException(e);
        }*/
    }
}
