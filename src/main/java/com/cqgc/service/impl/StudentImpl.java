package com.cqgc.service.impl;

import com.cqgc.mapper.StudentMapper;
import com.cqgc.pojo.Student;
import com.cqgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getSbase(String phone) {
        System.out.println(studentMapper.getSbase(phone));
        return studentMapper.getSbase(phone);
    }

    @Override
    public int insertExael(Student student) {
        return studentMapper.insertExael(student);
    }
}
