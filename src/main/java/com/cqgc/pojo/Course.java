package com.cqgc.pojo;

public class Course {
    private int courseId;
    private int classId;
    private String courseName;

//    是否已评价
    private int evaluation;
    private int teacherId;
    private String teacherName;

//    /选修必修
    private int type;
    private String term;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", classId=" + classId +
                ", courseName='" + courseName + '\'' +
                ", evaluation=" + evaluation +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", type=" + type +
                ", term='" + term + '\'' +
                '}';
    }
}
