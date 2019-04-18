package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:CollectionDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月11日21:45
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class CollectionDto extends BaseDto {

    private static final long serialVersionUID = -1000578826003198173L;
    private Long newsId;
    private Long collectUserId;
    private String newsTitle;
}
