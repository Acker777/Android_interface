package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public int login(String username,String password){
        return userService.queryUserByName(username,password);
    }

    @RequestMapping("/registernewuser")
    public int register(User user){
        System.out.println(user);
        return userService.insertUser(user);
    }


}
