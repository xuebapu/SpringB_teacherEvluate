package com.cqgc.mapper;

import com.cqgc.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {

    @Select("select * from question")
    List<Question> selectAll();

    @Update("update question set type = #{question.type},title = #{question.title} where id = #{question.id}")
    int updateById (@Param("question") Question question);
}
