package com.cqgc.service.impl;

import com.cqgc.mapper.NavMapper;
import com.cqgc.pojo.Nav;
import com.cqgc.service.NavService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavServiceImpl implements NavService {

    @Autowired
    NavMapper navMapper;

    @Override
    public List<Nav> getNavAll() {
        return navMapper.getNavAll();
    }

    @Override
    public List<Nav> getNav(String perms) {
        return navMapper.getNav(perms);
    }

    @Override
    public int insertDept(Nav nav) {
        return navMapper.insertDept(nav);
    }

    @Override
    public int xGdept(String oldName, String deptName) {
        return navMapper.xGdept(oldName,deptName);
    }

    @Override
    public int upNav(Nav nav) {
        return navMapper.upNav(nav);
    }

}
