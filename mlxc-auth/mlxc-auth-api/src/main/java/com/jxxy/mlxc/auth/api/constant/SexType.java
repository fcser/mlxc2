package com.jxxy.mlxc.auth.api.constant;

/**
 * @Project:mlxc-parent
 * @Class:SexType
 * @author:zhouyangmin@myhexin.com
 * @CreateTime:2019年03月26日20:57
 * @Description:性别枚举类
 * @Version: 1.0.0
 */
public enum SexType {
    /** 男 */
    MALE(0,"男"),
    /** 外表 */
    FEMALE(1,"女");

    private Integer type;
    private String sex;

    private SexType(Integer type,String sex){
        this.type = type;
        this.sex=sex;
    }

    public Integer getType() {
        return type;
    }

    public String getName(){
        return sex;
    }
    public static Integer getTypeByName(String name){
        if (name != null) {
            if (MALE.getName().equals(name)) {
                return MALE.getType();
            }
            if (FEMALE.getName().equals(name)) {
                return FEMALE.getType();
            }
        }
        return null;
    }
    /**
     * 检查是否是允许的类型
     *
     * @param type
     * @return true 允许，false 不允许
     */
    public static boolean isAcceptType(Integer type) {
        if (type != null) {
            return (FEMALE.getType().equals(type) || MALE.getType().equals(type));
        }
        return false;
    }

    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static SexType getByType(Integer type) {
        if (type != null) {
            if (FEMALE.getType().equals(type)) {
                return FEMALE;
            }
            if (MALE.getType().equals(type)) {
                return MALE;
            }
        }
        return null;
    }
}
