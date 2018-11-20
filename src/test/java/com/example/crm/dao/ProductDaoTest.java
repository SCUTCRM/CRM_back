package com.example.crm.dao;

import com.example.crm.entity.Document;
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

    @Autowired
    private PriceDao priceDao;

    @Autowired
    private StockInfoDao stockInfoDao;

    @Test
    //@Ignore
    public void getProductList() {
        System.out.println(productDao.getProductList());
    }

    @Test
    //@Ignore
    public void getProductById() {
        System.out.println(productDao.getProductById(1));
    }

    @Test
    //@Ignore
    public void insertProduct() {
        Product product = new Product();
        product.setProductName("thinkpad");
        product.setPartNumber(1);
        product.setSaleStartDate(new Date());
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
        Price price = new Price();
        price.setPriceId(1);
        product.setPrice(price);
        StockInfo stockInfo = new StockInfo();
        stockInfo.setStockInfoId(1);
        product.setStockInfo(stockInfo);
        Document document=new Document();
        document.setDocumentId(1);
        product.setDocument(document);
        System.out.println(productDao.insertProduct(product));
    }

    @Test
    //@Ignore
    public void updateProduct() {
        Product product = productDao.getProductById(3);
        product.setProductName("thinkpad X1");
        product.setPartNumber(2);
        product.setSaleStartDate(new Date());
        product.setProductCategory("电脑");
        product.setActive("F");
        product.setSaleEndDate(new Date());
        product.setProductNumber(1);
        product.setWebsite("www.thinkPad.com");
        product.setVentorName("美国良心想");
        product.setVentorPartno(1);
        product.setCreateTime(new Date());
        product.setModifiedTime(new Date());
        product.setManufacturer("联想");
        product.setDescription("测试");
        product.setUpdateInfo("更改产品");
        Price price = new Price();
        price.setPriceId(1);
        product.setPrice(price);
        StockInfo stockInfo = new StockInfo();
        stockInfo.setStockInfoId(3);
        product.setStockInfo(stockInfo);
        Document document=new Document();
        document.setDocumentId(1);
        product.setDocument(document);
        System.out.println(productDao.updateProduct(product));
    }

    @Test
    //@Ignore
    public void getProduct() {
        Product product = new Product();
        product.setProductName("thinkpad");
        product.setPartNumber(1);
        Price price=new Price();
        price.setUnitPrice(5.0);
        price.setCommissionRate(10.01);
        Price priceTest=priceDao.getPrice(price);
        product.setPrice(priceTest);
        StockInfo stockInfo=new StockInfo();
        stockInfo.setQtyInStock(100);
        stockInfo.setUnit(1);
        StockInfo stockInfoTest=stockInfoDao.getStockInfo(stockInfo);
        product.setStockInfo(stockInfoTest);
        System.out.println(productDao.getProduct(product));
    }

    @Test
    //@Ignore
    public void deleteProduct() {
        System.out.println(productDao.deleteProduct(2));
    }

    @Test
    //@Ignore
    public void getUpdateInfo() {
        System.out.println(productDao.getUpdateInfo(1));
    }

    @Test
    //@Ignore
    public void findDuplicates() {
        System.out.println(productDao.findDuplicates());
    }
}