package com.edu.service.impl;

import com.edu.entity.User;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional //声明此方法加入事务
    public int addUser(User user) {
        userMapper.insertUser(user);
        System.out.println(1/0);
        userMapper.deleteUser(10001);
        return 1;
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUser(long id) {
        return userMapper.deleteUser(id);
    }
}