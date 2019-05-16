package com.jxxy.mlxc.websocket.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project:mlxc-parent
 * @Class:LoggerMessage
 * @author:zhouyangmin
 * @CreateTime:2019年05月15日19:13
 * @Description:
 * @Version: 1.0.0
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoggerMessage
{
    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private String exception;
    private String cause;
}
