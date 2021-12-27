package com.example.pojo;

import java.util.Date;

public class RegisterStudent {
    private String register_id;
    private String studentNum;
    private Date studentRegisterTime;

    public String getRegister_id() {
        return register_id;
    }

    public void setRegister_id(String register_id) {
        this.register_id = register_id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Date getStudentRegisterTime() {
        return studentRegisterTime;
    }

    public void setStudentRegisterTime(Date studentRegisterTime) {
        this.studentRegisterTime = studentRegisterTime;
    }
}
