package com.example.service;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int queryUserByName(String name,String password) {
        User user = userMapper.queryUserByName(name,password);
        if(user==null){
            return -1;
        }else {
            return user.getIsStudent();
        }
    }

    @Override
    public int insertUser(User user) {
        try {
           return userMapper.insertUser(user);
        } catch (org.springframework.dao.DuplicateKeyException e) {
            e.printStackTrace();
            return 2;
        } catch (Exception e){
            e.printStackTrace();
            return 3;
        }

    }
}
