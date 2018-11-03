package com.example.crm.service;

import com.example.crm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 10:04
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void userExitOrNot() {
        System.out.println(userService.userExitOrNot("liu bin"));
        System.out.println(userService.userExitOrNot("刘斌"));
        System.out.println(userService.userExitOrNot("1"));
        System.out.println(userService.userExitOrNot("2"));
    }

    @Test
    public void getUser() {
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(3);
        user.setUserName("刘斌"); //name属性无法修改
        user.setPassWord("13265910904zly");
        user.setPhone("13672814949");

        System.out.println(userService.updateUser(user));
    }
}