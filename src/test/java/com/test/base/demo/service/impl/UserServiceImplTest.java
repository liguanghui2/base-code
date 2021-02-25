package com.test.base.demo.service.impl;

import com.test.base.demo.BaseCodeApplication;
import com.test.base.demo.bean.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李光辉
 * @version 1.0
 * @date 2021/2/25 10:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseCodeApplication.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setAge(18);
        user.setName("test");
        user.setStatus(1);
        for (int i = 1; i <= 10; i++) {
            user.setUserNum(i);
            Long resultId = userServiceImpl.addUser(user);
            System.out.println(resultId);
        }
    }

    @Test
    public void selectUsersByUserNumTest() {
        List<User> users = userServiceImpl.selectUsersByUserNum(1);
        System.out.println(users);
    }
}
