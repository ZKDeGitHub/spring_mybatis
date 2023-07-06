package com.edu.service;
import com.edu.entity.User;

public interface UserService {
    User queryById(int id);

    int addUser(User user);

    int editUser(User user);

    int removeUser(long id);
}