package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:EntryUserDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月08日9:55
 * @Description:报名人信息
 * @Version: 1.0.0
 */
@Data
public class EntryUserDto extends BaseDto {

    private static final long serialVersionUID = -8576127006773598162L;
    private String phone;
    private String userName;
    private Integer sex;
    private Integer age;
}
