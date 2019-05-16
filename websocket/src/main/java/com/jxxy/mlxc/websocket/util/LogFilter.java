package com.jxxy.mlxc.websocket.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.jxxy.mlxc.websocket.api.LoggerMessage;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Project:mlxc-parent
 * @Class:LoggerFilter
 * @author:zhouyangmin
 * @CreateTime:2019年05月15日19:18
 * @Description:
 * @Version: 1.0.0
 */

@Service
public class LogFilter extends Filter<ILoggingEvent>
{
    @Override
    public FilterReply decide(ILoggingEvent event)
    {
        String exception = "";
        IThrowableProxy iThrowableProxy1 = event.getThrowableProxy();
        if (iThrowableProxy1 != null)
        {
            exception = "<span class='excehtext'>" + iThrowableProxy1.getClassName() + " " + iThrowableProxy1.getMessage() + "</span></br>";
            for (int i = 0; i < iThrowableProxy1.getStackTraceElementProxyArray().length; i++)
            {
                exception += "<span class='excetext'>" + iThrowableProxy1.getStackTraceElementProxyArray()[i].toString() + "</span></br>";
            }
        }
        LoggerMessage loggerMessage = new LoggerMessage(event.getMessage(), DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())), event.getThreadName(), event.getLoggerName(),
                event.getLevel().levelStr, exception, "");
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}
