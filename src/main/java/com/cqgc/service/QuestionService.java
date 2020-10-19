package com.cqgc.service;

import com.cqgc.pojo.Question;

import java.util.List;

public interface QuestionService {

    List<Question> selectAll();

    int updateById (Question question);
}
