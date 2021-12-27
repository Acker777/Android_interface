package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.Register;
import com.example.vo.CourseInfo;
import com.example.vo.RegisterInfo;
import com.example.vo.RegisterPageInfo;

import java.util.List;

public interface TeacherCourseService {
    int addCourse(Course course);

    int addRegister(Register register);

    List<Course> queryCourseByTeacherNum(int num);

    List<RegisterInfo> getRegisterList(String courseId);

    CourseInfo getCourseInfo(String courseId);

    RegisterPageInfo getRegPageInfo(String registerId);

//    List<RegisterInfo> getRegisterList(String courseId);
}
