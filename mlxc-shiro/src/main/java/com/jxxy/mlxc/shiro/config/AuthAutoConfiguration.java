/**
 * 
 */
package com.jxxy.mlxc.shiro.config;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
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
@Slf4j
@ConditionalOnProperty(prefix = "mlxc", name = "isShiroEnable", havingValue = "true")
public class AuthAutoConfiguration {

	 /**
     * 需要登录用户
     */
    private static final String WHO_HAVE_AUTH = "authc";
    /**
     * 所有人可访问
     */
    private static final String EVERYONE = "anon";
    /**
     * 管理员权限
     */
    private static final String WHO_IS_ADMIN="roles[admin]";
    /**
     * 商家权限
     */
    private static final String WHO_IS_BUSINESS="roles[business]";
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
    public DefaultWebSecurityManager securityManager(@Autowired @Lazy AuthorizingRealm realm) {
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
    @Primary
    public RolesFilter rolesFilter(){
        return new RolesFilter();
    }
    @Bean
    @Primary
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }
    @Bean(name="shiroFilter")
    @Primary
    public ShiroFilterFactoryBean shiroFilter(@Autowired DefaultWebSecurityManager securityManager,
    		//@Autowired SessionFilter sessionFilter,
            //@Autowired RolesFilter rolesFilter,
            @Autowired NewAuthProperties newAuthProperties) {
    	ShiroFilterFactoryBean shiro=new ShiroFilterFactoryBean();
    	shiro.setSecurityManager(securityManager);
        shiro.setLoginUrl(newAuthProperties.getNoLoginUrl());
        shiro.setUnauthorizedUrl(newAuthProperties.getNoRoleUrl());
    	//设置过滤器
    	Map<String,Filter> filterMap=new LinkedHashMap<>();
    	/*filterMap.put(WHO_HAVE_AUTH, sessionFilter);
        *//*filterMap.put(WHO_IS_BUSINESS, sessionFilter);
        filterMap.put(WHO_IS_ADMIN, sessionFilter);*/
        /*filterMap.put(WHO_IS_BUSINESS, rolesFilter);
        filterMap.put(WHO_IS_ADMIN, rolesFilter);*/
    	shiro.setFilters(filterMap);
    	Map<String,String> chainMap = new LinkedHashMap<>();
    	/* 自定义拦截链添加 ，顺序很重要*/
        log.info("authProperty:{}",newAuthProperties.getAuthFilter());
        Arrays.stream(newAuthProperties.getAuthFilter()).forEach(path -> chainMap.put(path, WHO_HAVE_AUTH));
        Arrays.stream(newAuthProperties.getBusinessFilter()).forEach(path -> chainMap.put(path, WHO_IS_BUSINESS));
        Arrays.stream(newAuthProperties.getAdminFilter()).forEach(path -> chainMap.put(path, WHO_IS_ADMIN));
        Arrays.stream(newAuthProperties.getNoFilter()).forEach(path -> chainMap.put(path, EVERYONE));
    	shiro.setFilterChainDefinitionMap(chainMap);
        return shiro;
    }
    /*@Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }*/
}
