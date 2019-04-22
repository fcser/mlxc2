package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:NewsData
 * @author:zhouyangmin
 * @CreateTime:2019年04月21日21:18
 * @Description:新闻数据
 * @Version: 1.0.0
 */
@Data
public class NewsDataDto extends BaseDto {


    private static final long serialVersionUID = 1183837925587094521L;

    private Integer goodNum;
    private Integer collectionNum;
    private Integer commentNum;
}
