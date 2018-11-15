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
 * @ Date       ：2018/11/3 10:10
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RegisterServiceImplTest {
    @Autowired
    private RegisterService registerService;

    @Test
    public void registerByUser() {
        User user = new User();
        user.setUserName("刘斌");
        user.setEmail("1316095861@qq.com");
        user.setPassWord("123456");
        user.setPhone("13265940904");
        System.out.println(registerService.register(user));
    }
}