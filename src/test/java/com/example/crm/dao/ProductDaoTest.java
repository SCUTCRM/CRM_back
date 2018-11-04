package com.example.crm.dao;

import com.example.crm.entity.Price;
import com.example.crm.entity.Product;
import com.example.crm.entity.StockInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:53
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    @Ignore
    public void getProductList() {
        System.out.println(productDao.getProductList());
    }

    @Test
    @Ignore
    public void getProduct() {
        System.out.println(productDao.getProduct(1));
    }

    @Test
    @Ignore
    public void insertProduct() {
        Product product=new Product();
        product.setProductId(1);
        product.setProductName("thinkpad");
        product.setPartNumber(1);
        product.setSaleStartDate(new Date(2018,1,2));
        product.setProductCategory("电脑");
        product.setActive("T");
        product.setSaleEndDate(new Date());
        product.setProductNumber(1);
        product.setWebsite("www.thinkPad.com");
        product.setVentorName("联想");
        product.setVentorPartno(1);
        product.setCreateTime(new Date());
        product.setModifiedTime(new Date());
        product.setManufacturer("联想");
        product.setDescription("测试");
        product.setUpdateInfo("插入产品");
        Price price=new Price();
        price.setPriceId(1);
        product.setPrice(price);
        StockInfo stockInfo=new StockInfo();
        stockInfo.setStockInfoId(1);
        product.setStockInfo(stockInfo);
        System.out.println(productDao.insertProduct(product));
    }

    @Test
    @Ignore
    public void updateProduct() {
        Product product=new Product();
        product.setProductId(1);
        product.setProductName("thinkpad");
        product.setPartNumber(1);
        product.setSaleStartDate(new Date(2018,1,2));
        product.setProductCategory("电脑");
        product.setActive("T");
        product.setSaleEndDate(new Date());
        product.setProductNumber(1);
        product.setWebsite("www.thinkPad.com");
        product.setVentorName("联想");
        product.setVentorPartno(1);
        product.setCreateTime(new Date());
        product.setModifiedTime(new Date());
        product.setManufacturer("联想");
        product.setDescription("测试");
        product.setUpdateInfo("更改产品");
        Price price=new Price();
        price.setPriceId(1);
        product.setPrice(price);
        StockInfo stockInfo=new StockInfo();
        stockInfo.setStockInfoId(1);
        product.setStockInfo(stockInfo);
        System.out.println(productDao.updateProduct(product));
    }

    @Test
    @Ignore
    public void deleteProduct() {
        System.out.println(productDao.deleteProduct(1));
    }
}