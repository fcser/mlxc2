package com.jxxy.mlxc.news.api.query;

import com.mlxc.basic.query.BaseQuery;
import lombok.Data;

/**
 * @Project:mlxc-parent
 * @Class:CollectionQuery
 * @author:zhouyangmin
 * @CreateTime:2019年04月18日14:08
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class CollectionQuery extends BaseQuery {

    private static final long serialVersionUID = 2034077161390963659L;
    private Long userId;
}
