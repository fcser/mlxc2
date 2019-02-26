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

    /** 继续请求 */
    CONTINUE(100, "继续请求"),
    /** 成功（GET、POST、PUT、DELETE、OPTIONS） */
    SUCCESS(200, "成功"),
    /** 账号问题 */
    ACCOUNT(209, "账号问题"),
    /** 首次登陆，需要完善个人信息 */
    ACCOUNT_FIRST_LOGIN(210, "首次登陆，需要完善个人信息"),
    /** 账号被冻结 */
    ACCOUNT_FREEZE(211, "账号被冻结"),
    /** 密码已失效 */
    ACCOUNT_PASSWORD_EXPIRE(212, "密码已失效"),
    /** 密码 快失效 需要提醒 */
    ACCOUNT_PASSWORD_EXPIRE_REMINDER(213, "密码快失效"),
    /** 参数错误 */
    FAIL_PARAMETER(400, "参数错误"),
    /** 身份认证错误（未登录） */
    FAIL_NOT_LOGIN(401, "未登录"),
    /** 没有对应权限 */
    FAIL_PERMISSION(403, "没有对应权限"),
    /** 请求超时 */
    FAIL_TIME_OUT(408, "请求超时"),
    // 同名数据已存在
    FAIL_CONFLICT(409, "同名数据已存在"),
    /** 服务器异常（以及其它问题） */
    FAIL_SYSTEM(500, "服务器异常"),
    /** 定时任务异常 */
    FAIL_JOB(502, "定时任务异常");

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
