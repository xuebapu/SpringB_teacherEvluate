package com.cqgc.service.impl;

import com.cqgc.mapper.TeacherMapper;
import com.cqgc.pojo.Teacher;
import com.cqgc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTbase(int teacherId) {
        return teacherMapper.getTbase(teacherId);
    }
}
