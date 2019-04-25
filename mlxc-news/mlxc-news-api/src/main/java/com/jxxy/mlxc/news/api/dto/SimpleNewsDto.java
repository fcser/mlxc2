package com.jxxy.mlxc.news.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Project:mlxc-parent
 * @Class:SimpleNewsDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月24日18:39
 * @Description:简单新闻dto
 * @Version: 1.0.0
 */
@Data
public class SimpleNewsDto implements Serializable {

    private static final long serialVersionUID = -4866029175212019544L;

    private Long id;
    private String title;
}
