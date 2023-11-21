package com.study.mapper;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Mapper层：也被称为DAO（Data Access Object）层
 * 主要负责数据持久化的操作，包括与数据库进行交互，进行数据的增删改查等操作。
 * 在Spring框架中，通常会使用MyBatis等ORM框架来简化数据库操作。
 */
@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(String username, String password);
}
