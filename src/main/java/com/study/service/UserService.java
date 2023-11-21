package com.study.service;

import com.study.pojo.User;

public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册
    void register(String userName, String password);
}
