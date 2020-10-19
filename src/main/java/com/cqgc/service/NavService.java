package com.cqgc.service;


import com.cqgc.pojo.Nav;

import java.util.List;

public interface NavService {

     List<Nav> getNavAll();

     List<Nav> getNav(String perms);

     int insertDept(Nav nav);

     int xGdept( String oldName, String deptName );

     int upNav(Nav nav);
}
