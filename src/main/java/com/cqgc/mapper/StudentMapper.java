package com.cqgc.mapper;

import com.cqgc.pojo.Course;
import com.cqgc.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {

    @Select("select * from student where phone = #{phone}")
    Student getSbase(@Param("phone") String phone);


    @Insert("insert into student (studentId,name,phone,sex,address,entranceData,classId,birth)values(#{student.studentId},#{student.name},#{student.phone},#{student.sex},#{student.address},#{student.entranceData},#{student.classId},#{student.birth})")
    int insertExael(@Param("student") Student student);

}
