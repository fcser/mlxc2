package com.jxxy.mlxc.websocket.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-parent
 * @Class:ResponseMessageDto
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月25日14:19
 * @Description:响应消息实体类
 * @Version: 1.0.0
 */
@Getter
@Setter
@ToString
public class ResponseMessageDto {
    private String name;
    private String content;
    public ResponseMessageDto(){

    }
    public ResponseMessageDto(String name,String content){
        this.name=name;
        this.content=content;
    }
}
