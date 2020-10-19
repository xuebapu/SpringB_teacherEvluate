package com.cqgc.controller;
import com.alibaba.fastjson.JSONObject;
import com.cqgc.pojo.Course;
import com.cqgc.pojo.Score;
import com.cqgc.pojo.Student;

import com.cqgc.service.CourseService;
import com.cqgc.service.ScoreService;
import com.cqgc.service.StudentService;

import com.cqgc.service.TeacherService;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class StudentContorller {

    @Autowired
    private StudentService service;

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ScoreService scoreService;

    int studentId;
    int classId;
    List<Course> coursesAll ;

    @RequestMapping("/getSbase")
    public Student getSbase(@Param("phone") String phone){
       Student student = service.getSbase(phone);
       studentId = student.getStudentId();
       classId = student.getClassId();
       return service.getSbase(phone);
    };

    @RequestMapping("/getYCourse")
    public List<Course> getCourse(){
        List<Course> course = courseService.getCourseByClassId(classId);
        coursesAll = new ArrayList<Course>();
        for (Course course1 : course) {
            if(course1.getEvaluation() == 1){
                coursesAll.add(course1);
            }
        }
        return coursesAll;
    };
    @RequestMapping("/getNCourse")
    public List<Course> getNCourse(){
        List<Course> course = courseService.getCourseByClassId(classId);
        coursesAll = new ArrayList<Course>();
        for (Course course1 : course) {
            if(course1.getEvaluation() == 0){
                coursesAll.add(course1);
            }
        }
        return coursesAll;
    };

    @RequestMapping("/insertExcel")
    public int insertExcel(@RequestBody String sysParams){
        List <Student> sys = JSONObject.parseArray(sysParams,Student.class);
        for(int i = 4;i < sys.size()+4 ; i++ ){
            sys.get(i-4).setClassId(1790005);
            sys.get(i-4).setStudentId( Integer.parseInt(sys.get(i-4).getClassId()+String.valueOf(i)));
            service.insertExael(sys.get(i-4));
        }
        return 1;
    }
//学生评分
    @RequestMapping("/setScore")
    public int setScore(@Param("studentId") String studentId,@Param("courseId") String courseId,@Param("scoreData") String scoreData){
        Score score = new Score();
        score.setStudentId(Integer.parseInt(studentId));
        score.setCourseId(Integer.parseInt(courseId));
        score.setScore(scoreData);

        if(scoreService.setScore(score) >0 && courseService.updateType(score.getCourseId()) >0){
            return 1;
        }else {
            return 0;
        }

    }
//    查看学生评分
    @RequestMapping("/getScore")
    public Score getScore(@Param("studentId") String studentId,@Param("courseId") String courseId){
        return scoreService.getScore(Integer.parseInt(studentId),Integer.parseInt(courseId));
    }


}
