package com.jxxy.mlxc.web.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jxxy.mlxc.news.api.dto.CommentDto;
import com.jxxy.mlxc.news.api.query.CommentQuery;
import com.jxxy.mlxc.news.api.service.CommentService;
import com.jxxy.mlxc.shiro.config.AuthUtil;
import com.mlxc.basic.constant.ReturnCode;
import com.mlxc.basic.dto.BaseReturnDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Project:mlxc-parent
 * @Class:CommentController
 * @author:zhouyangmin
 * @CreateTime:2019年04月04日19:23
 * @Description:评论控制器
 * @Version: 1.0.0
 */
@Controller
@Slf4j
@RequestMapping("/mlxc")
public class CommentController {
    @Reference(version = "1.0.0")
    private CommentService commentService;

    /**
     * 评论
     * @param dto
     * @return
     */
    @PostMapping("/desk/comment.do")
    @ResponseBody
    public Object addComment(@RequestBody CommentDto dto){
        dto.setCommentUserId(AuthUtil.getUserId());
        log.info("dto；{}",dto);
        commentService.insert(dto);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 获取评论数量
     * @param newsId
     * @return
     */
    @GetMapping("/commentNums.do")
    @ResponseBody
    public Object getCommentNums(@RequestParam("newsId")Long newsId){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,commentService.countComments(newsId));
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PostMapping("/desk/giveALike.do")
    @ResponseBody
    public Object giveALike(@RequestParam("id")Long id){
        Long userId=AuthUtil.getUserId();
        if(commentService.isGiveLike(id,userId)){
            return new BaseReturnDto<>(ReturnCode.SUCCESS.getCode(),"已点赞,不可重复点赞");
        }
        commentService.giveALike(id,userId);
        return new BaseReturnDto<>(ReturnCode.SUCCESS);
    }

    /**
     * 获取评论列表
     * @param newsId
     * @return
     */
    @GetMapping("/getComments.do")
    @ResponseBody
    public Object getComments(@RequestParam("newsId") Long newsId){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,commentService.getComments(newsId));
    }

    /**
     * 获取与我相关的评论
     * @param commentQuery
     * @return
     */
    @GetMapping("/desk/getMyComments.do")
    @ResponseBody
    public Object getMyComments(@ModelAttribute CommentQuery commentQuery){
        commentQuery.setCreateUserId(AuthUtil.getUserId());
        return new BaseReturnDto<>(ReturnCode.SUCCESS,commentService.getMyComments(commentQuery));
    }
    /**
     * 获取与我相关的评论
     * @return
     */
    @GetMapping("/desk/countMyComments.do")
    @ResponseBody
    public Object countMyComments(){
        return new BaseReturnDto<>(ReturnCode.SUCCESS,commentService.myCommentNum(AuthUtil.getUserId()));
    }
}
