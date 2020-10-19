package com.cqgc.pojo;

public class Score {
    private int Id;
    private int studentId;
    private int courseId;
    private String score;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "Id=" + Id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", score='" + score + '\'' +
                '}';
    }
}
