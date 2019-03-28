package com.jxxy.mlxc.auth.api.constant;

/**
 * @Project:mlxc-parent
 * @Class:RoleType
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月27日18:52
 * @Description:角色枚举类
 * @Version: 1.0.0
 */
public enum RoleType {
    USER(1),
    ADMIN(2),
    BUSINESS(3);
    private Integer type;
    RoleType(Integer type){
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
            return (USER.getType().equals(type) ||ADMIN.getType().equals(type)||BUSINESS.getType().equals(type));
        }
        return false;
    }

    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static RoleType getByType(Integer type) {
        if (type != null) {
            if (USER.getType().equals(type)) {
                return USER;
            }
            if (ADMIN.getType().equals(type)) {
                return ADMIN;
            }
            if (BUSINESS.getType().equals(type)) {
                return BUSINESS;
            }
        }
        return null;
    }
}
