package com.edu.service.impl;

import com.edu.config.SpringConfig;
import com.edu.entity.User;
import com.edu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void queryById() {
        System.out.println(userService.queryById(10001));
    }

    @Test
    public void add() {
        userService.addUser(new User(10011L, "诸葛亮", LocalDate.now(), "男", "周口的"));
    }

    @Test
    public void edit() {
        User user = new User();
        user.setId(10005L);
        user.setUserName("阿斗");
        userService.editUser(user);
    }

    @Test
    public void remove() {
        userService.removeUser(10004);
    }
}