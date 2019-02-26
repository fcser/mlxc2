/**
 * 
 */
package org.mlxc.news.service;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jxxy.mlxc.news.NewsApplication;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.utils.NewsTrumpTools;

/**
 * @Project:mlxc-news-service
 * @Class:RedisTest.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月25日下午4:51:40
 * @Description:
 * @Version: 1.0.0 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {NewsApplication.class})
@WebAppConfiguration
public class RedisTest {

	@Autowired
	private StringRedisTemplate redis=null;
	@Test
	public void redisTest() throws Exception {
		NewsTrumpTools tools=new NewsTrumpTools(redis);
		for(Long i=0L;i<8L;i++) {
			NewsDO dto=new NewsDO();
			dto.setId(i);
			dto.setTitle("xinwen:"+i);
			dto.setIntro("呵呵呵呵");
			dto.setCreateUserId(i);
			tools.postNews(dto);
		}
		redis.opsForSet().add(NewsTrumpTools.GROUP+"walk", NewsTrumpTools.NEWS+"7");
		redis.opsForSet().add(NewsTrumpTools.GROUP+"walk", NewsTrumpTools.NEWS+"6");
		redis.opsForSet().add(NewsTrumpTools.GROUP+"walk", NewsTrumpTools.NEWS+"1");
		tools.newsVote( "3", "7");
		tools.newsVote( "3", "1");
		tools.newsVote( "3", "7");
		tools.newsVote( "4", "7");
		tools.newsVote( "10", "1");
		tools.newsVote( "2", "7");
		ArrayList<Map<Object, Object>> articles=tools.getNews(1,10,"score:");
		for(int i=0;i<articles.size();i++) {
			System.out.println(articles.get(i).get("title"));//7
		}
		System.out.println("---群组排序----");//7
		ArrayList<Map<Object, Object>> news=tools.getGroupArticles("walk", 1, 10, "score:");
		for(int i=0;i<articles.size();i++) {
			System.out.println(news.get(i).get("title"));//7
		}
		/*System.out.println(articles.size());
		System.out.println(articles.get(0).get("title"));//7
		System.out.println(articles.get(1).get("title"));
		System.out.println(articles.get(2).get("title"));
		System.out.println(articles.get(0).get("votes"));//5
		System.out.println(articles.get(4).get("votes")+" "+articles.get(3).get("title"));*/
	}
}
