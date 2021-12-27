package com.example;

import com.example.pojo.Register;
import com.example.service.TeacherCourseService;
import com.example.vo.CourseInfo;
import com.example.vo.RegisterInfo;
import com.example.vo.RegisterPageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringbootAndroidRegisterSystemApplicationTests {

    @Autowired
    TeacherCourseService service;

    @Test
    void contextLoads() {

        String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        System.out.println(substring);

    }

}
