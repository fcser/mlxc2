package com.jxxy.mlxc.news.api.model;

import com.mlxc.basic.dto.BaseDO;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:CollectionDO
 * @author:zhouyangmin
 * @CreateTime:2019年04月03日21:32
 * @Description:收藏DO
 * @Version: 1.0.0
 */
@Data
public class CollectionDO extends BaseDO {

    private static final long serialVersionUID = -8824901812965679880L;
    private Long newsId;
    private Long CollectUserId;
}
