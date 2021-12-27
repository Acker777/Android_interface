package com.example.service;


import com.example.pojo.User;

public interface UserService {

    int queryUserByName(String name,String password);

    int insertUser(User user);
}
