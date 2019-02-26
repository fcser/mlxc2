package com.mlxc.basic.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project:mlxc-basic
 * @Class:BaseDto.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月19日下午8:17:51
 * @Description:与前后台交互或service层交互所用数据的base类，包含id，createTime和updateTime
 */
@Getter
@Setter
@ToString
public class BaseDto implements Serializable {

    private static final long serialVersionUID = -5298897576119093054L;

    /**
     * id 主键
     */
    private Long id;
    private Date createTime;
	private Date updateTime;
}
