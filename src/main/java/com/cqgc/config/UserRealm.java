package com.cqgc.config;


import com.cqgc.pojo.User;
import com.cqgc.service.UserService;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();

        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());

        return info;
    }
    //认证
    @Override
    protected  AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=》授权doGetAuthenticationInf");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //链接数据库
        User user = userService.login(userToken.getUsername());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String code1 = (String) session.getAttribute("code");

//        减少支出
       String code = "1111";


        if(user == null){
            return null;
        }



        //密码认证，

        return new SimpleAuthenticationInfo(user,code,"");
    }
}
