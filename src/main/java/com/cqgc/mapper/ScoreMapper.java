package com.cqgc.mapper;

import com.cqgc.pojo.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreMapper {

    @Insert("insert into score (studentId,courseId,score) values(#{score.studentId},#{score.courseId},#{score.score})")
    int setScore(@Param("score") Score score);

    @Select("select * from score where studentId = #{studentId} and courseId = #{courseId}")
    Score getScore(@Param("studentId")int studentId,@Param("courseId") int courseId);
}
