package com.cqgc.service;

import com.cqgc.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {

    List<Course> getCourseByClassId(@Param("classId") int classId);

    int updateType(int courseId);
}
