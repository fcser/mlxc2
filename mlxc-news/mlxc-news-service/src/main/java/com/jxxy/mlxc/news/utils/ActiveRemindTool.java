package com.jxxy.mlxc.news.utils;

import com.jxxy.mlxc.news.api.dto.ActiveUserDto;
import com.jxxy.mlxc.news.mapper.ActiveDAO;
import com.mlxc.basic.util.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:ActiveRemindTool
 * @author:zhouyangmin
 * @CreateTime:2019年04月10日19:54
 * @Description:活动定时提醒器
 * @Version: 1.0.0
 */
@Component
@ConditionalOnProperty(prefix = "mlxc", name = "isSendActiveMsgEnable", havingValue = "true")
@Configuration
@Slf4j
public class ActiveRemindTool {
    /**
     * 实现思路：定时器+阻塞队列，队列生产者为所有活动创建线程，插入活动信息，根据时间对阻塞对列进行排序
     * 活动时间开始前24小时，发送短信，并取出下一个活动，创建定时任务。可能不可行
     * 思路二：创建一个定时器，每隔一个小时扫描一次数据库，若有匹配时间的活动，则查询出活动的报名者，给他们发短信
     */
    @Autowired
    @Lazy
    private ActiveDAO activeDAO;


    private static int beforeHour;
    @Value("${mlxc.beforeHour:10}")
    public void setBeforeHour(int beforeHour){
        this.beforeHour=beforeHour;
    }

    public static int getBeforeHour(){
        return beforeHour;
    }
    /**
     * 每一个小时执行一次定时器
     * 不知道这样快速的请求，秒滴云服务器能不能受得了
     */
    @Scheduled(cron="0 2 * * * ? ")
    public void sendMsg(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.HOUR,+beforeHour);//beforeHour小时后
        String date=simpleDateFormat.format(calendar.getTime());
        log.info("查询出{}的活动",date);
        //查询出所有要这个时间要举行的活动
        List<ActiveUserDto> list=activeDAO.selectActiveByTime(date);
        log.info("send message to {} users",list.size());
        if(null!=list&&list.size()>0){
            list.stream().forEach(e->{
                String msg="【忆美.上狮】尊敬的"+e.getUserName()+",您报名的活动{"+e.getActiveName()+"}将于"+e.getBeginTime()+"开始，请您提前半小时到场！";
                SmsUtil.sendMsg(e.getPhone(),msg);
            });
        }
    }
}
