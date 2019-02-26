package com.mlxc.basic.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project:mlxc-basic
 * @Class:BaseDo.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月19日下午8:18:25
 * @Description:数据库字段基类，有id，createTime和updateTime
 */
@Getter
@Setter
@ToString
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -3964061212042653107L;

    private Long id;
    private Date createTime;
    private Date updateTime;

}