package com.cqgc.controller;

import com.aliyuncs.utils.StringUtils;
import com.cqgc.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class SmsApiController {

    @Autowired
    private SendSms sendSms;

    @RequestMapping("/send")
    public String code(@RequestParam String phone){
        //调用发送方法
//        String code = redisTemplate.opsForValue().get(phone);
//        if(!StringUtils.isEmpty(code)){
//            return phone + ":" + code + "已存在，还没过期";
//        }
        String code = "";
//       生成验证码斌存储到redis 中
        code = UUID.randomUUID().toString().substring(0,4);
        HashMap<String,Object> param = new HashMap<>();
        param.put("code",code);

        System.out.println(phone);

        boolean isSend = sendSms.send(phone,"SMS_201717555",param);


        if(isSend){
            return code;
        }else {
            return "error";
        }
    }
}
