package com.example.controller;

import com.example.pojo.Course;
import com.example.pojo.Register;
import com.example.vo.CourseInfo;
import com.example.vo.RegisterInfo;
import com.example.vo.RegisterPageInfo;
import com.example.vo.RegisterStudentInfo;
import com.example.service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherCourseController {

    @Autowired
    TeacherCourseService teacherCourseService;

    @RequestMapping("/addCourse")
    public int addCourse(Course course){
        return teacherCourseService.addCourse(course);
    }

    @RequestMapping("/queryCourseByTeacherNum/{num}")
    public List<Course> queryCourseByTeacherNum(@PathVariable int num){
        return teacherCourseService.queryCourseByTeacherNum(num);
    }
    /**
     * 发起签到
     * @param registerForm
     * @return
     */
    @GetMapping("/register")
    public Integer addRegister(Register registerForm){
        System.out.println("registerForm"+registerForm);
        int i = teacherCourseService.addRegister(registerForm);
        return i;
    }

    /**
     * 根据课程ID查询签到记录
     * @param courseId
     * @return
     */
    @GetMapping("/register/{courseId}/regList")
    public List<RegisterInfo> getRegisterListByCourseId(@PathVariable String courseId){
        return teacherCourseService.getRegisterList(courseId);
    }

    /**
     * 获得课程信息
     * @param courseId
     * @return
     */
    @GetMapping("/register/{courseId}/courseInfo")
    public List<CourseInfo> getCourseInfoByCourseId(@PathVariable String courseId){
        List<CourseInfo> list = new ArrayList<CourseInfo>();
        list.add(teacherCourseService.getCourseInfo(courseId));
        return list;
    }

    /**
     * 签到详细页面信息
     * @param registerId
     * @return
     */
    @GetMapping("/register/{registerId}")
    public List<RegisterPageInfo> getRegisterDetail(@PathVariable String registerId){
        List<RegisterPageInfo> list = new ArrayList<RegisterPageInfo>();
        list.add(teacherCourseService.getRegPageInfo(registerId));
        return list;
    }


}
