package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.news.api.constant.AuditFlag;
import com.jxxy.mlxc.news.api.constant.Type;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.jxxy.mlxc.news.api.service.ActiveService;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class NewsController {
    @Reference(version = "1.0.0")
    private NewsService newsService;
    @Reference(version = "1.0.0")
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
    @PostMapping("/desk/addArticle.do")
    @ResponseBody
    public Object insertArticle(@RequestBody NewsDto news){
        news.setType(Type.ARTICLE.getType());
        news.setCreateUserId(AuthUtil.getUserId());
        newsService.insert(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @PostMapping("/manage/insertNews.do")
    @ResponseBody
    public Object insertNews(@RequestBody NewsDto news){
        news.setType(Type.NEWS.getType());
        news.setAuditFlag(AuditFlag.PASS.getType());
        news.setCreateUserId(AuthUtil.getUserId());
        newsService.insert(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @PostMapping("/manage/updateNews.do")
    @ResponseBody
    public Object updateNews(@RequestBody  NewsDto news){
        log.info("newsDTO:{}",news.toString());
        news.setUpdateUserId(AuthUtil.getUserId());
        newsService.update(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 文章审核
     * @param news
     * @return
     */
    @PostMapping("/manage/checkArticle.do")
    @ResponseBody
    public Object checkArticle(@RequestBody  NewsDto news){
        news.setUpdateUserId(AuthUtil.getUserId());
        newsService.checkArticle(news);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @DeleteMapping("/manage/delNews.do")
    @ResponseBody
    public Object deleteNews(@RequestParam("newsId") Long newsId){
        newsService.delete(newsId);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }
    @DeleteMapping("/manage/batchDelNews.do")
    @ResponseBody
    public Object batchDelNews(List<Long> newsIds){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.batchDelete(newsIds));
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PostMapping("/desk/like.do")
    @ResponseBody
    public Object giveALike(@RequestParam("id") Long id){
        Long userId=AuthUtil.getUserId();
        if(newsService.isGiveALike(userId,id)>0){
            return new BaseReturnDto<>(ReturnCode.REPEAT.getCode(),"不可重复点赞");
        }
        newsService.giveALike(userId,id);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 是否已经点赞
     * @param id
     * @return
     */
    @PostMapping("/desk/isLike.do")
    @ResponseBody
    public Object isLike(@RequestParam("id") Long id){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.isGiveALike(AuthUtil.getUserId(),id));
    }

    /**
     * 获取我发表的文章
     * @param newsQuery
     * @return
     */
    @GetMapping("/desk/myArticle.do")
    @ResponseBody
    public Object getMyArticle(@ModelAttribute NewsQuery newsQuery){
        newsQuery.setCreateUserId(AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.getMyArticle(newsQuery));
    }
    /**
     * 按时间排序获取新闻
     * @param newsQuery
     * @return
     */
    @GetMapping("/getNewsByTime.do")
    @ResponseBody
    public Object getNewsByTime(@ModelAttribute NewsQuery newsQuery){
        //newsQuery.setCreateUserId(AuthUtil.getUserId());
        log.info("newsQuery:{}",newsQuery.toString());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.getNewsByTime(newsQuery));
    }

    /**
     * 获取新闻数据
     * @return
     */
    @GetMapping("/getNewsdata.do")
    @ResponseBody
    public Object getNewsDate(@RequestParam("newsId") Long newsId){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.getNewsData(newsId));
    }

    /**
     * 用于活动绑定
     * @return
     */
    @GetMapping("/manage/getSimpleNews.do")
    @ResponseBody
    public Object getSimpleNews(){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,newsService.getSimpleNews(AuthUtil.getUserId()));
    }
}
