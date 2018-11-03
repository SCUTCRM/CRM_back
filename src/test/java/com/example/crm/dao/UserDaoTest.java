package com.example.crm.dao;

import com.example.crm.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 9:46
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void getUser() {
        System.out.println(userDao.getUser("刘斌"));
    }

    @Test
    //@Ignore
    public void insertUser() {
        User user = new User();
        user.setUserName("刘斌");
        user.setEmail("1145054472@qq.com");
        user.setPassWord("123456");
        user.setPhone("13265940904");
        user.setTitle("学生");

        System.out.println(userDao.insertUser(user));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("刘斌"); //不可变
        user.setEmail("1");
        user.setPassWord("123");
        user.setPhone("7887227");
        System.out.println(userDao.updateUser(user));
    }
}