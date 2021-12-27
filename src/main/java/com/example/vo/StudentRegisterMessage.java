package com.example.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class StudentRegisterMessage {
    String registerId;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    String registerName;
    Date registerDateTime;
    int isregister;

    public StudentRegisterMessage(String registerId, String registerName, Date registerDateTime, int isregister) {
        this.registerId = registerId;
        this.registerName = registerName;
        this.registerDateTime = registerDateTime;
        this.isregister = isregister;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterDateTime() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.registerDateTime);
    }

    public void setRegisterDateTime(String registerDateTime) {
        System.out.println("执行了日期转换！");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.registerDateTime=simpleDateFormat.parse(registerDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getIsregister() {
        return isregister;
    }

    public void setIsregister(int isregister) {
        this.isregister = isregister;
    }
}
