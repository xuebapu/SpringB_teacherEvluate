package com.cqgc.controller;


import com.cqgc.pojo.Departement;
import com.cqgc.pojo.Nav;
import com.cqgc.pojo.Question;
import com.cqgc.service.*;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {

    @Autowired
    private NavService navService;

    @Autowired
    private UserService userService;
    @Autowired
    private SendSms sendSms;

    @Autowired
    private DeptServiec deptServiec;

    @Autowired
    private QuestionService questionService;

    String perms;
    String code = "";

    @RequestMapping("/getyzm")
    public String code(@RequestParam String phone){

        if (userService.login(phone) == null) {
            return "0";
        }else {
            code = UUID.randomUUID().toString().substring(0,4);
            HashMap<String,Object> param = new HashMap<>();
            param.put("code",code);

            boolean isSend = sendSms.send(phone,"SMS_201717555",param);

            if(isSend){
                return "2";
            }else {
//                应该为1 减少支出
                return "2";
            }
        }
    }

    @RequestMapping("/login")
    public String login(@RequestParam("phone") String phone, @RequestParam("yzm") String yzm, Model model){
        //获取用户
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("code",code);

        //封装用户登录信息
        UsernamePasswordToken token = new UsernamePasswordToken(phone,yzm);

        try{
            subject.login(token);//执行登陆方法  没有异常就说明ok
            perms = userService.login(phone).getPerms();
            return perms;
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","电话不存在");
            return "0";
        }catch (IncorrectCredentialsException e) {//密码不存在
            model.addAttribute("msg", "验证码错误");
            return "-1";
        }
    }

//    获取所有导航权限
    @RequestMapping("/getNavAll")
    public List<Nav> getNavAll(){
        return navService.getNavAll();
    }
//    修改权限
    @RequestMapping("/upNav")
    public int upNav(@Param("id")String id,@Param("name")String name,@Param("level1")String level1,@Param("level2")String level2,@Param("perms")String perms,@Param("url")String url){
        Nav nav = new Nav();
        nav.setId(Integer.parseInt(id));
        nav.setName(name);
        nav.setLevel1(level1);
        nav.setLevel2(level2);
        nav.setPerms(perms);
        nav.setUrl(url);
        if(navService.upNav(nav) > 0){
            return 1;
        }else{
            return 0;
        }
    }
//    添加权限
    @RequestMapping("/addNav")
    public int addNav(@Param("name")String name,@Param("level1")String level1,@Param("level2")String level2,@Param("perms")String perms,@Param("url")String url){
        Nav nav = new Nav();
        nav.setName(name);
        nav.setLevel1(level1);
        nav.setLevel2(level2);
        nav.setPerms(perms);
        nav.setUrl(url);

        if(navService.insertDept(nav) > 0){
            return 1;
        }else {
            return 0;
        }
    }

//获取导航
    @RequestMapping("/getNav")
    public List<Nav> getNav(){
        System.out.println(navService.getNav(perms));
        return navService.getNav(perms);
    }
//更新院系
    @RequestMapping("/InsertDept")
    public int InsertDept(@Param("deptName") String deptName,@Param("deptId") String deptId){
//更新导航
        Nav nav = new Nav();
        nav.setName(deptName);
        nav.setLevel1("90"+deptId);
        nav.setLevel2("0");
        nav.setPerms("3");
        nav.setUrl("to"+deptName);

        //更新院系
        Departement departement = new Departement();
        departement.setDeptId(deptId);
        departement.setDeptName(deptName);

        if(navService.insertDept(nav)!=0 && deptServiec.insertDept(departement)!= 0){
            return 1;
        }else {
            return 0;
        }
    }
//查询院系
    @RequestMapping("/deptSelectAll")
    public List<Departement> deptSelectAll(){
        System.out.println(deptServiec.deptSelectAll());
        return deptServiec.deptSelectAll();
    }

//    修改院系
    @RequestMapping("/xGdept")
    public int xGdept(@Param("oldName")String oldName,@Param("deptName") String deptName,@Param("deptId") String deptId ){
        Departement departement = new Departement();
        departement.setDeptId(deptId);
        departement.setDeptName(deptName);


        if(deptServiec.xGdept(departement) != 0 && navService.xGdept(oldName,deptName) != 0){
            return 1;
        }else {
            return 0;
        }
    }

//    获得题库
    @RequestMapping("/selectAll")
    public List<Question> selectAll(){
        return questionService.selectAll();
    }

//    修改题库
    @RequestMapping("/updateById")
    public int updateById (@Param("id") String id,@Param("title") String title,@Param("type") String type){
        Question question = new Question();
        question.setId(Integer.parseInt(id));
        question.setTitle(title);
        question.setType(type);
        if(questionService.updateById(question) > 0){
            return 1;
        }else {
            return 0;
        }

    }
//    增加题库

}
