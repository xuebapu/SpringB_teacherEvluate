package com.cqgc.service;

import com.cqgc.mapper.TeacherMapper;
import com.cqgc.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TeacherService {

    Teacher getTbase(int teacherId);
}
