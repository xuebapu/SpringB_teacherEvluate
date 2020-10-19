package com.cqgc.mapper;

import com.cqgc.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where teacherId = #{teacherId} or tphone = #{teacherId}")
    Teacher getTbase(@Param("teacherId") int teacherId);

}
