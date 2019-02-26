package com.mlxc.basic.query;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project:mlxc-basic
 * @Class:BaseQuery.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日上午9:49:02
 * @Description:查询基础类，包含pageNum,pageSize还有name
 * 
 */
@Getter
@Setter
@ToString
public class BaseQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5481113344323993729L;
	private Integer pageNum=1;
	private Integer pageSize=10;
	private String name;
	/**
	 * 是否用redis推荐策略，默认0，推荐
	 */
	private Integer isRecommend=0;
	
}
