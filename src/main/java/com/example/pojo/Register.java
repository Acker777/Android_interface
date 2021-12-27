package com.example.pojo;

import java.util.Date;

public class Register {
    private String registerId;
    private String registerName;
    private String courseId;
    private Date registerTime;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerId='" + registerId + '\'' +
                ", registerName='" + registerName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
