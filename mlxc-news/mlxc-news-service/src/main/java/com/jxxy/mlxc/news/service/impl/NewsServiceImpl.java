/**
 * 
 */
package com.jxxy.mlxc.news.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.news.converter.NewsConverter;
import com.jxxy.mlxc.news.mapper.NewsDAO;
import com.jxxy.mlxc.news.utils.NewsTrumpTools;
import com.mlxc.basic.dto.BaseDO;

/**
 * @Project:mlxc-news-service
 * @Class:NewsServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午5:08:13
 * @Description:
 * @Version: 1.0.0 
 *存在问题：1，未加入分组
 *2.一旦缓存雪崩，没有备份数据，查询很可能失败
 */
@Service(version="1.0.0",interfaceClass=NewsService.class)
@Component
@Transactional(rollbackFor=Exception.class)
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDAO newsDAO;
	@Autowired
	NewsConverter newsConverter;
	@Autowired
	private StringRedisTemplate redis=null;
	
	
	@Override
	public Long insertActiveId(NewsDO newsDO) {
		return newsDAO.insertActiveId(newsDO);
	}
	@Override
	public Long insert(NewsDto news) {
		NewsDO newsDO=newsConverter.fromNewsDto(news);
		newsDAO.insert(newsDO);
		//插入redis中
		NewsTrumpTools tools=new NewsTrumpTools(redis);
		tools.postNews(newsDO);
		return news.getId();
	}
	@Override
	public PageInfo<NewsDto> findByPage(NewsQuery query) {
		if(query.getIsRecommend().equals(0)) {
			//启用推荐系统
			NewsDto dto=new NewsDto();
			NewsTrumpTools tools=new NewsTrumpTools(redis);
			//按评分高低查询
			List<Map<Object,Object>> listR=tools.getNews(query.getPageNum(), query.getPageSize(), NewsTrumpTools.SCORE);
			if(listR!=null&&listR.size()>0) {
				List<NewsDto> list1=new ArrayList<>();
				/*list1=listR.stream().map(s->{
					dto.setId(Long.parseLong((String) s.get("id")));
					dto.setTitle((String) s.get("title"));
					dto.setIntro((String)s.get("intro"));
				}).collect(Collectors.toList());*/
				for(int i=0;i<listR.size();i++) {
					dto.setId(Long.parseLong((String) listR.get(i).get("id")));
					dto.setTitle((String) listR.get(i).get("title"));
					dto.setIntro((String)listR.get(i).get("intro"));
					list1.add(dto);
				}
				return new PageInfo<>(list1);
			}
		}
		PageHelper.startPage(query.getPageNum(),query.getPageSize());
		List<NewsDto> list=newsDAO.find(query);
		return new PageInfo<>(list);
	}
	@Override
	public int delete(Long id) {
		//先删除缓存，再删数据库
		NewsTrumpTools tools=new NewsTrumpTools(redis);
		tools.deleteNews(id.toString());
		return newsDAO.delete(id);
	}
	@Override
	public int batchDelete(List<Long> ids) {
		if(ids==null) {
			return 0;
		}
		NewsTrumpTools tools=new NewsTrumpTools(redis);
		ids.stream().map(s->s.toString()).forEach(tools::deleteNews);
		/*for(int i=0;i<ids.size();i++) {
			tools.deleteNews(ids.get(i).toString());
		}*/
		return newsDAO.batchDelete(ids);
	}
	@Override
	public int update(BaseDO dto) {
		return newsDAO.update(dto);
	}
	@Override
	public NewsDto select(Long userId,Long newsId) {
		//每一次查询新闻，就相当于给他打了一次分，但一个用户只能打一次分
		NewsTrumpTools tools=new NewsTrumpTools(redis);
		tools.newsVote(userId.toString(), newsId.toString());
		return newsDAO.select(newsId);
	}


}
