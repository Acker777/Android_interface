package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user where user_num = #{name} and user_password = #{password}")
    User queryUserByName(@Param("name") String name,@Param("password") String password);

    @Insert("insert into user (user_num, user_password, user_name, is_student) values (#{userNum}, #{userPassword}, #{userName}, #{isStudent})")
    int insertUser(User user) throws Exception;
}
