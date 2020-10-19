package com.cqgc.service;

import com.cqgc.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    public User login(String phone);
}
