package com.mlxc.basic.constant;

/**
 * 
 * @Project:mlxc-basic
 * @Class:ReturnCode.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月19日下午8:24:02
 * @Description:
 */
public enum ReturnCode {


    /** 成功（GET、POST、PUT、DELETE、OPTIONS） */
    SUCCESS(200, "成功"),
    /**登录异常*/
    FAIL_LOGIN(202,"登录错误"),
    /** 身份认证错误（未登录） */
    FAIL_NOT_LOGIN(401, "未登录，请先登录"),
    /** 没有对应权限 */
    FAIL_ROLE(403, "非法访问，请先获得该角色"),
    /** 请求超时 */
    FAIL_TIME_OUT(408, "请求超时"),
    /** 服务器异常（以及其它问题） */
    FAIL_SYSTEM(500, "服务器异常");

    private Integer code;

    private String message;

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage(){
        return this.message;
    }
}
