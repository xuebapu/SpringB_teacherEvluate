package com.cqgc.controller;

import com.cqgc.pojo.Teacher;
import com.cqgc.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTbase")
    public Teacher getTbase(@Param("teacherId") int teacherId){
       return teacherService.getTbase(teacherId);
    }

}
