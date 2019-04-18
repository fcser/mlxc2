package com.jxxy.mlxc.news.api.constant;

/**
 * @Project:mlxc-parent
 * @Class:NewsType
 * @author:zhouyangmin
 * @CreateTime:2019年04月01日20:26
 * @Description:新闻所属模块
 * @Version: 1.0.0
 */

public enum NewsType {
    OTHER(0),
    FOOD(1),
    HOME(2),
    WALK(3),
    SPORT(4);
    private Integer type;
    NewsType(Integer type){
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
            return (FOOD.getType().equals(type) ||HOME.getType().equals(type)||WALK.getType().equals(type)
                    ||SPORT.getType().equals(type)||OTHER.getType().equals(type));
        }
        return false;
    }

    /**
     * 根据类型返回枚举类型类，用于switch
     *
     * @param type
     * @return
     */
    public static NewsType getByType(Integer type) {
        if (type != null) {
            if (FOOD.getType().equals(type)) {
                return FOOD;
            }
            if (HOME.getType().equals(type)) {
                return HOME;
            }
            if (WALK.getType().equals(type)) {
                return WALK;
            }
            if (SPORT.getType().equals(type)) {
                return SPORT;
            }
            if(OTHER.getType().equals(type)){
                return OTHER;
            }
        }
        return null;
    }
}
