package com.jxxy.mlxc.news.api.constant;

/**
 * @Project:mlxc-parent
 * @Class:Type
 * @author:zhouyangmin
 * @CreateTime:2019年04月01日20:39
 * @Description:文章来源，来自用户就是美文
 * @Version: 1.0.0
 */
public enum Type {
    NEWS(1),
    ARTICLE(2);
    private Integer type;
    Type(Integer type){
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
            return (ARTICLE.getType().equals(type) ||NEWS.getType().equals(type));
        }
        return false;
    }

    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static Type getByType(Integer type) {
        if (type != null) {
            if (NEWS.getType().equals(type)) {
                return NEWS;
            }
            if (ARTICLE.getType().equals(type)) {
                return ARTICLE;
            }
        }
        return null;
    }
}
