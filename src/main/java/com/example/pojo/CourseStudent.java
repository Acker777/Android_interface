package com.example.pojo;

public class CourseStudent {
    private String courseId;
    private String studentNum;

    @Override
    public String toString() {
        return "CourseStudent{" +
                "courseId='" + courseId + '\'' +
                ", studentNum='" + studentNum + '\'' +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}
