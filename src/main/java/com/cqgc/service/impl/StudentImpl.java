package com.cqgc.service.impl;

import com.cqgc.mapper.StudentMapper;
import com.cqgc.pojo.Student;
import com.cqgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String phone) {
        return studentMapper.login(phone);
    }
}
