package com.cqgc.service;

import com.cqgc.pojo.Score;

public interface ScoreService {

    int setScore(Score score);

    Score getScore(int studentId,int courseId);
}
