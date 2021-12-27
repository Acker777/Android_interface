package com.example.controller;

import com.example.service.CourseService;
import com.example.service.CourseServiceImpl;
import com.example.vo.CourseMessage;
import com.example.vo.StudentRegisterMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@RestController
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @RequestMapping("/getCourseMessage/{student_num}")
    public List<CourseMessage> getCourseMessage(@PathVariable("student_num") String student_num) {
        return courseService.getCourseMessages(student_num);
    }

    @RequestMapping("/studentEnterCourse/{course_id}/{student_num}")
    public boolean studentEnterCourse(@PathVariable String course_id, @PathVariable String student_num) {
        return courseService.studentEnterCourse(course_id, student_num);
    }

    @RequestMapping("/getTeacherNameByCourseId/{courseId}")
    public String getTeacherNameByCourseId(@PathVariable String courseId) {
        return courseService.getTeacherNameByCourseId(courseId);
    }

    @RequestMapping("/getStudentRegisterMessages/{courseId}/{studentNum}")
    public List<StudentRegisterMessage> getStudentRegisterMessages(@PathVariable String courseId, @PathVariable String studentNum) {
        return courseService.getStudentRegisterMessages(courseId, studentNum);
    }

    @RequestMapping("/judgeIsRegister/{courseId}/{studentId}")
    public Map<Object, Object> judgeIsRegister(@PathVariable String courseId, @PathVariable String studentId) {
        return courseService.judgeIsRegister(courseId, studentId);
    }

    @RequestMapping("/studentRegister/{registerId}/{studentNum}")
    public int studentRegister(@PathVariable String registerId, @PathVariable String studentNum) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        Date date = new Date();
        date = simpleDateFormat.parse(simpleDateFormat.format(date));
        return courseService.studentRegister(registerId, studentNum, date);
    }
}
