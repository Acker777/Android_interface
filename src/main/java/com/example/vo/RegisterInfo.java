package com.example.vo;

public class RegisterInfo {
    private String registerId;
    private String registerName;
    private String registerTime;

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "registerId='" + registerId + '\'' +
                ", registerName='" + registerName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }

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

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
