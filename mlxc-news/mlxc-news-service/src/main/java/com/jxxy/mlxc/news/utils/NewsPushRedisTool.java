package com.jxxy.mlxc.news.utils;

import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.news.converter.NewsConverter;
import com.mlxc.basic.query.BaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project:mlxc-parent
 * @Class:NewsPushRedisTool
 * @author:zhouyangmin
 * @CreateTime:2019年04月19日18:10
 * @Description:缓存失效后重建缓存工具类
 * @Version: 1.0.0
 */
@Component
public class NewsPushRedisTool {

    private NewsTrumpTools newsTrumpTools=new NewsTrumpTools(new StringRedisTemplate());
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsConverter newsConverter;

    /**
     * 重新建立缓存，将数据库数据打进去
     * @return
     */
    public Integer pushNews(){
        List<NewsDto> list=newsService.getNews();
        List<NewsDO> list1=list.stream().map(e->newsConverter.fromNewsDto(e)).collect(Collectors.toList());
        list1.stream().forEach(e->
            newsTrumpTools.reBuildRedis(e));
        return list1.size();
    }
}
