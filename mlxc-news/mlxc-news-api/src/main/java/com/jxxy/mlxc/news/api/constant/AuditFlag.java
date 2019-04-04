package com.jxxy.mlxc.news.api.constant;

/**
 * @Project:mlxc-parent
 * @Class:AuditFlag
 * @author:zhouyangmin
 * @CreateTime:2019年04月01日20:32
 * @Description:文章审核状态
 * @Version: 1.0.0
 */
public enum AuditFlag {
    WAIT(0),
    PASS(1),
    UNPASS(2);
    private Integer type;
    AuditFlag(Integer type){
        this.type=type;
    }
    public Integer getType() {
        return type;
    }


    /**
     * 检查是否是允许的类型
     *
     * @param type
     * @return true 允许，false 不允许
     */
    public static boolean isAcceptType(Integer type) {
        if (type != null) {
            return (WAIT.getType().equals(type) ||PASS.getType().equals(type)||UNPASS.getType().equals(type));
        }
        return false;
    }

    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static AuditFlag getByType(Integer type) {
        if (type != null) {
            if (WAIT.getType().equals(type)) {
                return WAIT;
            }
            if (PASS.getType().equals(type)) {
                return PASS;
            }
            if (UNPASS.getType().equals(type)) {
                return UNPASS;
            }
        }
        return null;
    }
}
