package com.jxxy.mlxc.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Project:mlxc-parent
 * @Class:WebSocketConfig
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月25日13:58
 * @Description:websocket配置类
 * @Version: 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker  //注解开启STOMP协议来传输基于代理的消息，此时控制器支持使用
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        //用户订阅主题前缀，/topic表示群发，/user表示点到点
        config.enableSimpleBroker("/topic","/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //注册两个端点
        //注册广播端点，允许跨域
        registry.addEndpoint("/websocket/webService").setAllowedOrigins("*").withSockJS();
        //注册点到点短笛，允许跨域
        registry.addEndpoint("/websocket/queueservice").setAllowedOrigins("*").withSockJS();
    }
}
