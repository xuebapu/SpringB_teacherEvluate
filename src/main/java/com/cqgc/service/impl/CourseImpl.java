package com.cqgc.service.impl;

import com.cqgc.mapper.CourseMapper;
import com.cqgc.pojo.Course;
import com.cqgc.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourseByClassId(@Param("classId") int classId) {
        return courseMapper.getCourseByClassid(classId);
    }

    @Override
    public int updateType(int courseId) {
        return courseMapper.updateType(courseId);
    }


}
