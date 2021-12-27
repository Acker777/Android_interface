package com.example.service;

import com.example.dao.TeacherCourseMapper;
import com.example.pojo.Course;
import com.example.pojo.CourseStudent;
import com.example.pojo.Register;
import com.example.vo.CourseInfo;
import com.example.vo.RegisterInfo;
import com.example.vo.RegisterPageInfo;
import com.example.vo.RegisterStudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService{

    @Autowired
    TeacherCourseMapper teacherCourseMapper;

    @Override
    public int addCourse(Course course) {
        try {
            return teacherCourseMapper.addCourse(course);
        } catch (org.springframework.dao.DuplicateKeyException e) {
            e.printStackTrace();
            return 2;
        } catch (Exception e){
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public int addRegister(Register register) {
        register.setRegisterId(UUID.randomUUID().toString().replace("-","").substring(0,5));
        register.setRegisterTime(new Date());

        List<CourseStudent> list = teacherCourseMapper.getCourseStudent(register.getCourseId());
        for(CourseStudent t : list){
            t.setCourseId(register.getRegisterId());
            System.out.println(list);
        }
        Integer result = teacherCourseMapper.addRegister(register);
        teacherCourseMapper.addRegStudentList(list);
        return result;
    }

    @Override
    public List<Course> queryCourseByTeacherNum(int num) {
        return teacherCourseMapper.queryCourseByTeacherNum(num);
    }

    @Override
    public List<RegisterInfo> getRegisterList(String courseId) {
        return teacherCourseMapper.getRegisterList(courseId);
    }

    @Override
    public CourseInfo getCourseInfo(String courseId) {
        CourseInfo res = teacherCourseMapper.getCourseInfo(courseId);
        Integer num = teacherCourseMapper.countStudentNum(courseId);
        res.setStudentNum(num == null ? 0 : num);
        return res;
    }

    @Override
    public RegisterPageInfo getRegPageInfo(String registerId) {
        RegisterPageInfo res = new RegisterPageInfo();
        res.setList(teacherCourseMapper.getRegStudentInfoList(registerId));
        int noRegCount = 0;
        for(RegisterStudentInfo temp : res.getList()){
            if(temp.getStudentRegisterTime() == null){
                noRegCount++;
            }
        }
        res.setStuNum(res.getList().size());
        res.setIsRegNum(res.getStuNum()-noRegCount);
        res.setNoRegNum(noRegCount);
        if(res.getStuNum() != 0){
            res.setRegRate( (double)res.getIsRegNum()/res.getStuNum());
        }
        return res;
    }
}
