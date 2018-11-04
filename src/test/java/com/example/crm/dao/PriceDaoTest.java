package com.example.crm.dao;

import com.example.crm.entity.Price;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:53
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceDaoTest {
    @Autowired
    private PriceDao priceDao;

    @Test
    @Ignore
    public void getPrice() {
        System.out.println(priceDao.getPrice(1));
    }

    @Test
    @Ignore
    public void insertPrice() {
        Price price=new Price();
        price.setPriceId(1);
        price.setCommissionRate(20.01);
        price.setUnitPrice(5.0);
        System.out.println(priceDao.insertPrice(price));
    }

    @Test
    @Ignore
    public void updatePrice() {
        Price price=new Price();
        price.setPriceId(1);
        price.setCommissionRate(20.01);
        price.setUnitPrice(5.0);
        System.out.println(priceDao.updatePrice(price));
    }

    @Test
    @Ignore
    public void deletePrice() {
        System.out.println(priceDao.deletePrice(1));
    }
}