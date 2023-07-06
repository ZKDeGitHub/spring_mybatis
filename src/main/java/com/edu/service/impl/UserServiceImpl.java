package com.edu.service.impl;

import com.edu.entity.User;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import org.springframework.stereotype.Service;

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
    public int addUser(User user) {
        return userMapper.insertUser(user);
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