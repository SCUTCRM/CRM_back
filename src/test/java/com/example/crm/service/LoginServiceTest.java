package com.example.crm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 10:08
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    public void loginByUser() {
        System.out.println(loginService.loginByUser("rain","123456"));
        System.out.println(loginService.loginByUser("123","123456"));
        System.out.println(loginService.loginByUser("rain","123"));
        System.out.println(loginService.loginByUser("rain","123456"));
        System.out.println(loginService.loginByUser("rain","19960610")); //被调离已测试通过
        System.out.println(loginService.loginByUser("1","123456"));
    }
}