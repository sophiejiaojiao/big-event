package com.study.service.impl;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import com.study.service.UserService;
import com.study.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service注解是一个标记注解，用于标记在业务层处理业务逻辑的类。 Spring会将被@Service注解的类作为bean进行管理。
 * Service层：也被称为业务逻辑层，主要负责业务逻辑的处理。
 * 这一层通常会使用到Mapper层的接口，完成具体的业务操作。Service层作为业务逻辑的核心，对外提供服务。
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        // 加密：调用MD5加密
        String md5String = Md5Util.getMD5String(password);
        // 添加
        userMapper.add(username, md5String);
    }
}
