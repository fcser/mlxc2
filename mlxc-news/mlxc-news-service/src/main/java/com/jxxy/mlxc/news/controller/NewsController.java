/**
 * 
 *//*

package com.jxxy.mlxc.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.jxxy.mlxc.news.api.dto.NewsDto;
import com.jxxy.mlxc.news.api.query.NewsQuery;
import com.jxxy.mlxc.news.api.service.NewsService;

*/
/**
 * @Project:mlxc-news-service
 * @Class:NewsController.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月20日下午8:06:52
 * @Description:
 * @Version: 1.0.0 
 *
 *//*

@Controller
public class NewsController {

	*/
/*@Autowired
	private NewsConverter newsConverter;*//*

	@Reference(version="1.0.0")
	private NewsService newsService;
	@GetMapping("/addNews.do")
	@ResponseBody
	public Object addNews() {
		*/
/*System.out.println("com in");
		NewsDO dto=new NewsDO();
		dto.setTitle("单元测试news");
		dto.setIntro("呵呵呵呵");
		dto.setContent("asdfasdf和压缩的哈市的风格很好看");
		dto.setCreateUserId(1L);
		//NewsDO newsDO=newsConverter.fromNewsDto(dto);
		newsService.sayHello();
		System.out.println("添加成功："+newsService.insert(dto));*//*

		NewsQuery query=new NewsQuery();
		query.setPageNum(1);
		query.setPageSize(3);
		PageInfo<NewsDto> dto=newsService.findByPage(query);
		return dto;
	}
}
*/
