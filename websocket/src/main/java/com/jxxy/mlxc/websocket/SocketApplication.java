package com.jxxy.mlxc.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @Project:mlxc-parent
 * @Class:SocketApplication
 * @author:zhouyangmin
 * @CreateTime:2019年05月15日19:28
 * @Description:
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableWebSocket
public class SocketApplication {

    public static void main(String[] args){
        SpringApplication.run(SocketApplication.class);
    }
}
