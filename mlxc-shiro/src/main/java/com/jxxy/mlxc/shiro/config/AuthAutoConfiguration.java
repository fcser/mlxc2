/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @Project:mlxc-shiro
 * @Class:AuthAutoConfiguration.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日下午9:04:38
 * @Description:shiro配置文件
 * @Version: 1.0.0 
 *
 */
@Configuration
@EnableConfigurationProperties({ShiroProperties.class})
public class AuthAutoConfiguration {

	 /**
     * 需要登录用户
     */
    private static final String WHO_HAVE_AUTH = "myauthc";
    /**
     * 所有人可访问
     */
    private static final String EVERYONE = "anon";
    @Bean
    @Primary
    public AuthorizingRealm authRalm() {
    	AuthRalm authRalm=new AuthRalm();
    	authRalm.setAuthenticationCachingEnabled(true);
    	authRalm.setCachingEnabled(true);
    	//权限缓存别名，需要区分权限和认证key
    	authRalm.setAuthenticationCacheName("authenticationCache");
    	authRalm.setAuthorizationCachingEnabled(true);
    	authRalm.setAuthorizationCacheName("authorizationCache");
    	return authRalm;
    }
    @Bean
    @Primary
    public DefaultWebSecurityManager securityManager(@Autowired AuthorizingRealm realm) {
    	DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
    	securityManager.setRealm(realm);
    	return securityManager;
    }
    @Bean
    @Primary
    public MySessionManager mySessionManager() {
    	return new MySessionManager();
    }
    @Bean
    @Primary
    public SessionFilter sessionFilter() {
    	return new SessionFilter();
    }
    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }
    @Bean("shiroFilter")
    @Primary
    public ShiroFilterFactoryBean shiroFilter(@Autowired DefaultWebSecurityManager securityManager,
    		@Autowired ShiroProperties shiroProperties,
    		@Autowired SessionFilter sessionFilter) {
    	ShiroFilterFactoryBean shiro=new ShiroFilterFactoryBean();
    	shiro.setSecurityManager(securityManager);
    	Map<String,Filter> filterMap=new LinkedHashMap<>();
    	filterMap.put(WHO_HAVE_AUTH, sessionFilter);
    	shiro.setFilters(filterMap);
    	Map<String,String> chainMap = new LinkedHashMap<>();
    	/* 自定义过滤链添加 */
        Arrays.stream(shiroProperties.getAuthFilter()).forEach(path -> chainMap.put(path, WHO_HAVE_AUTH));
        //Arrays.stream(shiroProperties.getLoginFilter()).forEach(path -> chainMap.put(path, WHO_HAVE_AUTH));
        Arrays.stream(shiroProperties.getNoFilter()).forEach(path -> chainMap.put(path, EVERYONE));
    	shiro.setFilterChainDefinitionMap(chainMap);
        return shiro;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
}
