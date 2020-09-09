package com.cqgc.controller;


import com.cqgc.service.SendSms;
import com.cqgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class StudentContorller {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SendSms sendSms;

    String code = "";

    @RequestMapping("/getyzm")
    public int code(@RequestParam String phone){

        if (studentService.login(phone) == null) {
            return 0;
        }else {
            code = UUID.randomUUID().toString().substring(0,4);
            HashMap<String,Object> param = new HashMap<>();
            param.put("code",code);

            boolean isSend = sendSms.send(phone,"SMS_201717555",param);

            if(isSend){
                return 2;
            }else {
                return 1;
            }
        }

    }


    @RequestMapping(value = "/login")
    public int login(@RequestParam("phone") String phone,@RequestParam("yzm") String yzm){

        if(studentService.login(phone) == null){
            return 0;
        }else {
            if(yzm.equals(code)){
                return 2;
            }else {
                return 1;
            }
        }
    }

}
