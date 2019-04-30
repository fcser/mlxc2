package com.jxxy.mlxc.web.auth;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Project:mlxc-parent
 * @Class:IpTest
 * @author:zhouyangmin
 * @CreateTime:2019年04月30日17:27
 * @Description:
 * @Version: 1.0.0
 */

public class IpTest {
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
    public static void main(String[] args){
        System.out.println("ip:"+getLocalAddress());
    }
}
