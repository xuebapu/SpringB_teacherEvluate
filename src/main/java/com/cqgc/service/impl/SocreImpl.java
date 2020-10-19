package com.cqgc.service.impl;

import com.cqgc.mapper.ScoreMapper;
import com.cqgc.pojo.Score;
import com.cqgc.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocreImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public int setScore(Score score) {
        return scoreMapper.setScore(score);
    }

    @Override
    public Score getScore(int studentId, int courseId) {
        return scoreMapper.getScore(studentId,courseId);
    }
}
