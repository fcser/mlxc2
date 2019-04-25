package com.jxxy.mlxc.news.api.constant;

import org.apache.zookeeper.data.ACL;

/**
 * @Project:mlxc-parent
 * @Class:IsCall
 * @author:zhouyangmin
 * @CreateTime:2019年04月24日20:30
 * @Description:是否进行短信提醒
 * @Version: 1.0.0
 */
public enum IsCall {
    CALL(1),
    NOTCALL(0);
    private Integer type;
    IsCall(Integer type){
        this.type=type;
    }
    public Integer getType() {
        return type;
    }


    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static IsCall getByType(Integer type) {
        if (type != null) {
            if ( CALL.getType().equals(type)) {
                return CALL;
            }
            if (NOTCALL.getType().equals(type)) {
                return NOTCALL;
            }
        }
        return null;
    }
}
