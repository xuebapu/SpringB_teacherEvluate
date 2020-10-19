package com.cqgc.mapper;

import com.cqgc.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course where classid=#{classId}")
    List<Course> getCourseByClassid(@Param("classId") int classId);

    @Update("update course set evaluation = 1 where courseId = #{courseId}")
    int updateType(@Param("courseId") int courseId);

}
