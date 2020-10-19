package com.cqgc.mapper;

import com.cqgc.pojo.Student;
import com.cqgc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
     @Select("select * from user where phone = #{phone}")
     User login(@Param("phone") String phone);
}
