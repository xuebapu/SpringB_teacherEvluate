package com.cqgc.service.impl;


import com.cqgc.mapper.UserMapper;

import com.cqgc.pojo.User;
import com.cqgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String phone) {
        return userMapper.login(phone);
    }
}
