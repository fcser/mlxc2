package com.jxxy.mlxc.websocket.util;

import com.jxxy.mlxc.websocket.api.LoggerMessage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Project:mlxc-parent
 * @Class:LoggerQueue
 * @author:zhouyangmin
 * @CreateTime:2019年05月15日19:17
 * @Description:
 * @Version: 1.0.0
 */

/*
 * 创建一个阻塞队列，作为日志系统输出的日志的一个临时载体
 */
public class LoggerQueue
{
    // 队列大小
    public static final int QUEUE_MAX_SIZE = 10000;
    private static LoggerQueue alarmMessageQueue = new LoggerQueue();
    // 阻塞队列
    private BlockingQueue blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue()
    {
    }

    public static LoggerQueue getInstance()
    {
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     *
     * @param log
     * @return
     */
    public boolean push(LoggerMessage log)
    {
        return this.blockingQueue.add(log);// 队列满了就抛出异常，不阻塞
    }

    /**
     * 消息出队
     *
     * @return
     */
    public LoggerMessage poll()
    {
        LoggerMessage result = null;
        try
        {
            result = (LoggerMessage) this.blockingQueue.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
