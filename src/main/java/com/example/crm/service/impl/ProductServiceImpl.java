package com.example.crm.service.impl;

import com.example.crm.dao.ProductDao;
import com.example.crm.entity.Product;
import com.example.crm.exception.OrganizationException;
import com.example.crm.exception.ProductException;
import com.example.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:23
 * @ Description：产品业务逻辑实现类
 * @ Modified By：
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Transactional
    @Override
    public Product getProduct(Integer productId) {
        return productDao.getProduct(productId);
    }

    @Override
    public int insertProduct(Product product) {
        if (product == null) {
            return 0;
        }
        try {
            int result = productDao.insertProduct(product);
            return result;
        } catch (Exception e) {
            throw new ProductException("插入产品失败",-1);
        }
    }

    @Transactional
    @Override
    public int updateProduct(Product product) {
        if (product == null || product.getProductId() == null) {
            return 0;
        }
        try {
            int result = productDao.updateProduct(product);
            return result;
        } catch (Exception e) {
            throw  new ProductException("更新产品失败",-1);
        }
    }

    @Transactional
    @Override
    public int deleteProduct(Integer productId) {
        if (productId == null) {
            return 0;
        }
        try {
            int result = productDao.deleteProduct(productId);
            return result;
        } catch (Exception e) {
            throw  new ProductException("删除产品失败",-2);
        }
    }
}
