/**
 * 
 */
package com.jxxy.mlxc.news.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.jxxy.mlxc.news.api.model.NewsDO;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project:mlxc-news-service
 * @Class:NewsTrumpTools.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月25日下午4:46:47
 * @Description:文章推荐
 * @Version: 1.0.0 
 *不知道为什么注入不进去
 */
@Slf4j
public class NewsTrumpTools {

	private RedisTemplate redis;
	//一周的时间
	private final long ONE_WEEK_SECONDS=7*86400;
	//投票分数基数
	private final int VOTE_SCORE=432;
			
	public static final String TIME="time:";
	public static final String VOTED="voted:";
	public static final String GROUP="group:";
	public static final String SCORE="score:";
	public static final String NEWS="news:";
	
	public NewsTrumpTools(RedisTemplate redis) {
		this.redis=redis;
	}
	public NewsTrumpTools() {
		
	}
	/**
	 * 添加文章到redis中
	 * @Param:
	 * @Return:String
	 */
	public String postNews(NewsDO newsDO) {
		return postNews(newsDO,getTime());
	}

	private String postNews(NewsDO newsDO,String time){
		//设置文章ID
		String newsId=newsDO.getId().toString();
		String news=NEWS+newsId;
		//将发布文章的用户添加到文章已投票名单里，并设置过期时间
		String voted=VOTED+newsId;
		redis.opsForSet().add(voted, newsDO.getCreateUserId().toString());
		//设置过期时间
		redis.expire(voted, (int) ONE_WEEK_SECONDS, TimeUnit.SECONDS);
		//将文章信息存储在hash散列表里面
		HashMap<String,String> hm=new HashMap<>();
		hm.put("title", newsDO.getTitle());
		hm.put("intro", newsDO.getIntro());
		hm.put("id", newsDO.getId().toString());
		hm.put("time", time);
		hm.put("votes", "1");
		redis.opsForHash().putAll(news, hm);
		//将文章添加到根据时间排序和评分的集合里面
		redis.opsForZSet().add(SCORE,news,dateToStamp()+VOTE_SCORE);
		redis.opsForZSet().add(TIME,news,dateToStamp());
		log.info("文章："+newsId+"发布redis成功");
		return newsId;
	}
	/**
	 * 删除文章
	 * @Param:
	 * @Return:void
	 */
	public void deleteNews(String newsId) {
		redis.delete(NEWS+newsId);
		redis.delete(VOTED+newsId);
		redis.opsForZSet().remove(SCORE, NEWS+newsId);
		redis.opsForZSet().remove(TIME, NEWS+newsId);
		log.info(NEWS+newsId+"删除成功！");
	}

	public boolean reBuildRedis(NewsDO newsDO){
		postNews(newsDO,new SimpleDateFormat("yyyyMMddHHmmss").format(newsDO.getCreateTime()));
		return newsVote(newsDO.getId(),newsDO.getGrade());
	}
	/**
	 * 重新建立缓存,投票
	 * @param newsId 新闻的id
	 * @param votes
	 * @return
	 */
	private boolean newsVote(Long newsId,int votes){
		String news=NEWS+newsId.toString();
		if(!newsExists(news)){
			return false;
		}
		redis.opsForZSet().incrementScore(SCORE, news, VOTE_SCORE*votes);
		redis.opsForHash().increment(news, "votes", votes);
		return true;
	}

	/**
	 * 检测缓存是否正常
	 * @return
	 */
	public boolean newsExists(String news){
		Map<Object, Object> newsData=redis.opsForHash().entries(news);
		if(newsData==null||newsData.isEmpty()){
			return false;
		}
		return true;
	}
	/**
	 * 用户文章投票
	 * @Param:用户id和新闻idnews
	 * @Return:void
	 */
	public String newsVote(String userId,String newsId) {
		// 检查文章是否存在
		String msg="点赞失败：重复点赞";
		String news=NEWS+newsId;
		Map<Object, Object> newsData=redis.opsForHash().entries(news);
		if(newsData==null||newsData.isEmpty()){
			return "文章不存在";
		}
		log.info("news:{}",newsData);
		//计算文章的投票截止时间
		long cutoff=dateToStamp()-ONE_WEEK_SECONDS;
		//检查是否还可以进行投票
		if(redis.opsForZSet().score(TIME, news)<cutoff) {
			msg="投票时间已过";
			//System.out.println("投票时间已过");
			return msg;
		}
		//如果用户是第一次为这篇文章投票，那么增加文章的投票数和评分
		//利用redis的set集合元素不可重复的特性
		if(redis.opsForSet().add(VOTED+newsId, userId)!=0) {
			redis.opsForZSet().incrementScore(SCORE, news, VOTE_SCORE);
			redis.opsForHash().increment(news, "votes", 1);
			msg="投票成功";
		}
		return msg;
	}
	/**
	 * 获取排序后文章的详细信息
	 * @throws Exception 
	 * @Param:
	 * @Return:ArrayList<Map<String,String>>
	 */
	public ArrayList<Map<Object,Object>> getNews(int pageNum,int pageSize,String order){
		/*if(!SCORE.equals(order)&&!TIME.equals(order)) {
			throw new Exception("请检查order是否正确。");
		}*/
		//设置获取文章的起始和结束索引
		int start=(pageNum-1)*pageSize;
		int end=start+pageSize-1;
		//获取多个文章id，以分值从大到小
		Set<String> newses=redis.opsForZSet().reverseRange(order, start, end);
		ArrayList<Map<Object,Object>> articles=new ArrayList<>();
		for(String news:newses) {
			//根据id获取文章详细信息
			Map<Object, Object> newsData=redis.opsForHash().entries(news);//jedis.hgetAll(id);
			newsData.put("news", news);
			articles.add(newsData);
		}
		return articles;
		
	}
	/**
	 * 添加文章进入群组
	 * @Param:
	 * @Return:void
	 */
	public void addRemoveGroups(String newsId,Set<String> toAdd,Set<String> toRemove) {
		String news=NEWS+newsId;
		//添加文章到所属的群组
		for(String group:toAdd) {
			redis.opsForSet().add(GROUP+group, news);
		}
		//从群组里面移除
		if(toRemove!=null)
			for(String group:toRemove) {
				redis.opsForSet().remove(GROUP+group, news);
			}
		System.out.println("文章群组分类完成。");
	}
	/**
	 * 取分组集合，与排序完成完整集的交集，对分组文章进行排序
	 * @throws Exception 
	 * @Param:
	 * @Return:ArrayList<Map<String,String>>
	 */
	public ArrayList<Map<Object, Object>> getGroupArticles(String group,int pageNum,int pageSize,String order) throws Exception{
		if(!SCORE.equals(order)&&!TIME.equals(order)) {
			throw new Exception("请检查order是否正确。");
		}
		//为每个群组的每种排序顺序创建一个键
		String key=order+group;
		//检查是否已经有缓存的排序结果
		if(!redis.hasKey(key)) {
			//根据评分或者发布时间对群组文章进行排序
			//ZParams params=new ZParams().aggregate(ZParams.Aggregate.MAX);
	
			redis.opsForZSet().intersectAndStore(GROUP+group,order,key);//.interstore(key, params,GROUP+group,order);
			//缓存60秒自后自动删除
			redis.expire(key, 60, TimeUnit.SECONDS);
		}
		return getNews(pageNum,pageSize,key);
	}
	//获取当前系统时间戳，以s为单位
	private long dateToStamp(){
		Date date = new Date();
	    long ts = date.getTime()/1000;
	    return ts;
	}
	
	private String getTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
			  	
}
