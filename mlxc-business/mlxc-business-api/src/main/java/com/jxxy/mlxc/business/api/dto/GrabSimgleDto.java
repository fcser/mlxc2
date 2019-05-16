package com.jxxy.mlxc.business.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:GrabSimgleDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月29日9:42
 * @Description:抢单表dto
 * @Version: 1.0.0
 */
@Data
public class GrabSimgleDto extends BaseDto {

    private static final long serialVersionUID = 3698934360629740868L;
    private Long productId;
    private Double price;
    private Integer count;
    private Integer useFlag;
    private Long createUserId;
}
