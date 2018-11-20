package com.example.crm.service.impl;

import com.example.crm.dao.LeadsDao;
import com.example.crm.dao.ProductDao;
import com.example.crm.entity.Leads;
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

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public List<Product> getProduct(Product product) {
        return productDao.getProduct(product);
    }

    @Transactional
    @Override
    public int insertProduct(Product product) {
        if (product == null) {
            return 0;
        }
        try {
            int result = productDao.insertProduct(product);
            return result;
        } catch (Exception e) {
            throw new ProductException("插入产品失败", -1);
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
            throw new ProductException("更新产品失败", -1);
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
            throw new ProductException("删除产品失败", -2);
        }
    }

    @Override
    public List<Product> getRecentlyModified() {
        return productDao.getRecentlyModified();
    }

    @Override
    public Product getUpdateInfo(Integer productId) {
        return productDao.getUpdateInfo(productId);
    }
}
