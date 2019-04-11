package com.jxxy.mlxc.news.api.dto;

import com.mlxc.basic.dto.BaseDto;
import lombok.Data;

import java.util.Date;

/**
 * @Project:mlxc-parent
 * @Class:ActiveUserDto
 * @author:zhouyangmin
 * @CreateTime:2019年04月11日12:40
 * @Description:用于短信发送的dto
 * @Version: 1.0.0
 */
@Data
public class ActiveUserDto extends BaseDto {

    private static final long serialVersionUID = -4803102773849672025L;
    private String phone;
    private String userName;
    private String activeName;
    private Date beginTime;
}
