package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.jxxy.mlxc.news.api.service.ActiveService;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:NewsController
 * @author:zhouyangmin
 * @CreateTime:2019年03月28日13:17
 * @Description:
 * @Version: 1.0.0
 */

@Controller
@RequestMapping("/mlxc")
public class NewsController {
    @Reference
    private NewsService newsService;
    @Reference
    private ActiveService activeService;
    /**
     * 获取新闻列表
     * @return
     */
    @GetMapping("/showNews.do")
    @ResponseBody
    public Object showNews(@ModelAttribute NewsQuery news){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.findByPage(news));
    }

    /**
     * 获取新闻详情
     * @return
     */
    @GetMapping("/getNew.do")
    @ResponseBody
    public Object getNews(Long id){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.select(AuthUtil.getUserId(),id));
    }
    @PostMapping("/manage/insertNews.do")
    @ResponseBody
    public Object insertNews(NewsDto news){
        newsService.insert(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @PostMapping("/manage/updateNews.do")
    @ResponseBody
    public Object updateNews(NewsDto news){
        newsService.update(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @DeleteMapping("/manage/delNews.do")
    @ResponseBody
    public Object deleteNews(Long newsId){
        newsService.delete(newsId);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @DeleteMapping("/manage/batchDelNews.do")
    @ResponseBody
    public Object batchDelNews(List<Long> newsIds){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.batchDelete(newsIds));
    }
}
