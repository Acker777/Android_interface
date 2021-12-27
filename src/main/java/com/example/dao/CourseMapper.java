package com.example.dao;

import com.example.vo.CourseMessage;
import com.example.vo.StudentRegisterMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CourseMapper {
    //获得学生加入的课程列表
    @Select("SELECT course_num,course_name FROM course_student JOIN course ON course_student.course_id=course.course_id JOIN USER ON student_num=user.user_num where student_num=#{student_num}")
    List<CourseMessage> getCourseMessages(String student_num);

    //学生加入到某个课程中
    @Insert("insert into course_student values(#{course_id},#{student_num})")
    int studentEnterCourse(String course_id,String student_num);

    //根据课号查询教师姓名
    @Select("select user_name from course join user on teacher_num =user_num where course_num=#{courseId}")
    String getTeacherNameByCourseId(String courseId);

    //根据学生学号，课号来得到学生的签到信息列表
    @Select("SELECT register_course.register_id, register_name,register_time,CASE WHEN student_register_time IS NULL THEN 0 ELSE 1 END AS isRegister FROM register_course JOIN register_student ON register_course.register_id=register_student.register_id where course_id=#{courseId} and student_num=#{studentNum} order by register_time desc")
    List<StudentRegisterMessage> getStudentRegisterMessages(String courseId,String studentNum);

    //判断现在是否正在签到
    //@Select("SELECT COUNT(*)  FROM register_course WHERE TIME_TO_SEC (TIMEDIFF(NOW(),register_time))<600 and course_id=#{courseId}")
    @Select("SELECT COUNT(*) courseIsRegister, CASE WHEN student_register_time IS NULL THEN 0 ELSE 1 END AS studentIsRegister  FROM register_course JOIN register_student ON register_course.`register_id`=register_student.`register_id` WHERE TIME_TO_SEC (TIMEDIFF(NOW(),register_time))<600 AND course_id=#{courseId} AND student_num=#{studentId}")
    Map<Object,Object> judgeIsRegister(String courseId, String studentId);

    //学生签到，将签到时间由null修改为当前时间
    @Update("update register_student set student_register_time=#{date} where register_id=#{registerId} and student_num=#{studentNum}")
    int studentRegister(String registerId, String studentNum, Date date);

}
