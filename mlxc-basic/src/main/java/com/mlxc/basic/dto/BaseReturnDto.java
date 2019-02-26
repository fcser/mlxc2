package com.mlxc.basic.dto;

import java.io.Serializable;

import com.mlxc.basic.constant.ReturnCode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project:mlxc-basic
 * @Class:BaseReturnDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月19日下午8:18:34
 * @Description:
 */
@Getter
@Setter
@ToString
public class BaseReturnDto<T> implements Serializable {

    private static final long serialVersionUID = -5078727797537765928L;

    /**
     * 返回码{@link ReturnCode}
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public BaseReturnDto() {
    }

    public BaseReturnDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseReturnDto(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseReturnDto(ReturnCode code, T data){
        this.code = code.getCode();
        this.msg = code.getMessage();
        this.data = data;
    }

    public BaseReturnDto(ReturnCode code){
        this.code = code.getCode();
        this.msg = code.getMessage();
    }
}
