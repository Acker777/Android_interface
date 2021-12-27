package com.example.dao;

import com.example.pojo.Course;
import com.example.pojo.CourseStudent;
import com.example.pojo.Register;
import com.example.vo.CourseInfo;
import com.example.vo.RegisterInfo;
import com.example.vo.RegisterStudentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherCourseMapper {

    @Insert("insert into course (course_id, course_num, course_name, teacher_num) values (#{courseId},#{courseNum},#{courseName},#{teacherNum})")
    int addCourse(Course course);

    @Insert("INSERT INTO register_course(register_id,register_name,course_id,register_time) values(#{registerId},#{registerName},#{courseId},#{registerTime})")
    Integer addRegister(Register register);

    @Select("SELECT register_id,register_name,register_time from register_course WHERE course_id = #{courseId}")
    List<RegisterInfo> getRegisterList(String courseId);

    @Select("SELECT course_id, course_num, course_name, teacher_num FROM course WHERE course_id = #{courseId}")
    CourseInfo getCourseInfo(String courseId);

    @Select("SELECT count(*) FROM course_student WHERE course_id = #{courseId}")
    Integer countStudentNum(String courseId);

    @Select("SELECT a.register_id,a.student_num,a.student_register_time,b.user_name FROM" +
            " register_student a INNER JOIN user b ON a.student_num = b.user_num WHERE a.register_id = #{registerId}")
    List<RegisterStudentInfo> getRegStudentInfoList(String registerId);

    @Select("SELECT course_id, student_num FROM course_student WHERE course_id = #{courseId}")
    List<CourseStudent> getCourseStudent(String courseId);

    @Insert("<script>INSERT INTO register_student(register_id,student_num) VALUES <foreach collection='list' item='item' separator=','> (#{item.courseId},#{item.studentNum})  </foreach> </script>")
    int addRegStudentList(List<CourseStudent> list);

    @Select("SELECT * from course where teacher_num = #{num}")
    List<Course> queryCourseByTeacherNum(int num);

}
