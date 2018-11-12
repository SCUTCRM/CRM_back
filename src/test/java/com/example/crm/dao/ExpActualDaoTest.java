package com.example.crm.dao;

import com.example.crm.entity.ExpActual;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/12 15:37
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpActualDaoTest {
    @Autowired
    private ExpActualDao expActualDao;

    @Test
    //@Ignore
    public void getExpActual() {
        System.out.println(expActualDao.getExpActual(1));
    }

    @Test
    //@Ignore
    public void insertExpActual() {
        ExpActual expActual=new ExpActual();
        expActual.setBudgetCost(100.0);
        expActual.setActualCost(110.0);
        expActual.setExpResponse("降低价格");
        expActual.setActualResponse("提高价格");
        expActual.setExpSaleCount(1000);
        expActual.setActualSaleCount(2000);
        expActual.setExpRoi(2.1);
        expActual.setActualRoi(10.5);
        System.out.println(expActualDao.insertExpActual(expActual));
    }

    @Test
    //@Ignore
    public void updateExpActual() {
        ExpActual expActual=expActualDao.getExpActual(2);
        expActual.setBudgetCost(200.0);
        expActual.setActualCost(210.0);
        expActual.setExpResponse("降低价格");
        expActual.setActualResponse("提高价格");
        expActual.setExpSaleCount(1000);
        expActual.setActualSaleCount(2000);
        expActual.setExpRoi(2.1);
        expActual.setActualRoi(0.5);
        System.out.println(expActualDao.updateExpActual(expActual));
    }

    @Test
    //@Ignore
    public void deleteExpActual() {
        System.out.println(expActualDao.deleteExpActual(2));
    }
}