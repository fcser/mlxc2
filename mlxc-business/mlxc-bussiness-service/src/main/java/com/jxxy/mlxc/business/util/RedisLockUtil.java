package com.jxxy.mlxc.business.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Project:mlxc-parent
 * @Class:RedisLockUtil
 * @author:zhouyangmin
 * @CreateTime:2019年04月22日11:10
 * @Description:分布式锁
 * @Version: 1.0.0
 */
@Slf4j
public final class RedisLockUtil {
    private static final int DEFAULT_EXPIRE=60;
    @Autowired
    private static StringRedisTemplate redisTemplate;

    private RedisLockUtil(){}

    /**
     * 加锁操作，缺陷，仍有一定概率发生死锁（在设置了key后，未设置过期时间，发生了宕机）
     * @param key
     * @param expire
     * @return true加锁成功，false加锁失败
     */
    public static boolean lock(String key,int expire){
        return redisTemplate.opsForValue().setIfAbsent(key,"1",expire, TimeUnit.SECONDS);
    }

    /**
     * 解锁操作
     * @param key
     */
    public static void unLock(String key){
        redisTemplate.delete(key);
    }

}
