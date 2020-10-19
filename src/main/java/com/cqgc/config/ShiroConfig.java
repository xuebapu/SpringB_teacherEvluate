package com.cqgc.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactory“3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro内置过滤器
        /*
        * anon:无需验证就可以用
        * authc：必须认证才能让问
        * user：必须拥有记住我功能才能用
        * perms：拥有对象资源的权限才能访问
        * role：拥有角色权限才能访问
        */
//        拦截
        Map<String,String> filterMap = new LinkedHashMap<>();
//        授权


//
        filterMap.put("/login","anon");
        filterMap.put("/getyzm","anon");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录请求
        bean.setLoginUrl("login");
//        //未授权跳转页面
//        bean.setUnauthorizedUrl("/login");

        return bean;
    }

    //DafaulWebSecurityManager”2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//      关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建 realm 对象  ，需要自定义类“1
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
