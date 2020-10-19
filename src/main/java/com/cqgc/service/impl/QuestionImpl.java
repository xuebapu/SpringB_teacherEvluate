package com.cqgc.service.impl;

import com.cqgc.mapper.QuestionMapper;
import com.cqgc.pojo.Question;
import com.cqgc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> selectAll() {
        return questionMapper.selectAll();
    }

    @Override
    public int updateById(Question question) {
        return questionMapper.updateById(question);
    }
}
