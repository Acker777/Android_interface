package com.example.service;

import com.example.vo.CourseMessage;
import com.example.vo.StudentRegisterMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface CourseService {
    List<CourseMessage> getCourseMessages(String student_num);
    boolean studentEnterCourse(String course_id,String student_num);
    String getTeacherNameByCourseId(String courseId);
    List<StudentRegisterMessage> getStudentRegisterMessages(String courseId, String studentNum);
    Map<Object,Object> judgeIsRegister(String courseId, String studentId);
    int studentRegister(String registerId, String studentNum, Date date);


}
