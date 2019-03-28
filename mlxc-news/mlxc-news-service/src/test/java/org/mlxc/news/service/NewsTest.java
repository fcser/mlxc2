/**
 * 
 */
package org.mlxc.news.service;

import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jxxy.mlxc.news.NewsApplication;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.model.NewsDO;
import com.jxxy.mlxc.news.api.service.NewsService;
import com.jxxy.mlxc.news.converter.NewsConverter;

/**
 * @Project:mlxc-news-service
 * @Class:NewsTest.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午5:18:18
 * @Description:
 * @Version: 1.0.0 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {NewsApplication.class})
@WebAppConfiguration
public class NewsTest {

	@Autowired
	private NewsConverter newsConverter;
	@Autowired
	private NewsService newsService;
	@Test
	public void testAdd() {
		/*NewsDto dto=new NewsDto();
		dto.setId(10L);
		dto.setTitle("单元测试news");
		dto.setIntro("呵呵呵呵");
		dto.setContent("asdfasdf和压缩的哈市的风格很好看");
		NewsDO newsDO=newsConverter.fromNewsDto(dto);
		System.out.println(newsDO.toString()+"  id:"+newsDO.getId());*/
		//System.out.println("添加成功："+newsService.insert(dto));
		NewsQuery query=new NewsQuery();
		query.setPageNum(1);
		query.setPageSize(3);
		PageInfo<NewsDto> dto=newsService.findByPage(query);
		System.out.println(dto.toString());
	}
}
