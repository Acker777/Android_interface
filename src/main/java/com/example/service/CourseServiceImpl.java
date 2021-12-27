package com.example.service;

import com.example.dao.CourseMapper;
import com.example.vo.CourseMessage;
import com.example.vo.StudentRegisterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CourseMessage> getCourseMessages(String student_num) {
        return courseMapper.getCourseMessages(student_num);
    }

    @Override
    public boolean studentEnterCourse(String course_id,String student_num) {
        try {
            if (0!=courseMapper.studentEnterCourse(course_id,student_num)){
                return true;
            }

        }catch (Exception e){
            System.out.println("异常----------------------");
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public String getTeacherNameByCourseId(String courseId) {
        return courseMapper.getTeacherNameByCourseId(courseId);
    }

    @Override
    public List<StudentRegisterMessage> getStudentRegisterMessages(String courseId, String studentNum) {
        return courseMapper.getStudentRegisterMessages(courseId,studentNum);
    }

    @Override
    public Map<Object,Object> judgeIsRegister(String courseId, String studentId) {
        return courseMapper.judgeIsRegister(courseId,studentId);
    }

    @Override
    public int studentRegister(String registerId, String studentNum, Date date) {
        return courseMapper.studentRegister(registerId,studentNum,date);
    }
}
