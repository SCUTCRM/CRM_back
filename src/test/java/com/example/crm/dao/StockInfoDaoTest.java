package com.example.crm.dao;

import com.example.crm.entity.StockInfo;
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
public class StockInfoDaoTest {
    @Autowired
    private StockInfoDao stockInfoDao;

    @Test
    //@Ignore
    public void getStockInfo() {
        System.out.println(stockInfoDao.getStockInfoById(1));
    }

    @Test
    //@Ignore
    public void insertStockInfo() {
        StockInfo stockInfo=new StockInfo();
        stockInfo.setUsageUnit("kg");
        stockInfo.setQtyInStock(100);
        stockInfo.setUnit(1);
        stockInfo.setQtyInDemand(50);
        System.out.println(stockInfoDao.insertStockInfo(stockInfo));
    }

    @Test
    //@Ignore
    public void updateStockInfo() {
        StockInfo stockInfo=stockInfoDao.getStockInfoById(2);
        stockInfo.setUsageUnit("T");
        stockInfo.setQtyInStock(2000);
        stockInfo.setUnit(5);
        stockInfo.setQtyInDemand(5000);
        System.out.println(stockInfoDao.updateStockInfo(stockInfo));
    }

    @Test
    //@Ignore
    public void deleteStockInfo() {
        System.out.println(stockInfoDao.deleteStockInfo(2));
    }
}