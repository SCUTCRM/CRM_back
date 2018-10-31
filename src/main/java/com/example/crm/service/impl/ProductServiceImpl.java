package com.example.crm.service.impl;

import com.example.crm.entity.Product;
import com.example.crm.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:23
 * @ Description：产品业务逻辑实现类
 * @ Modified By：
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(String productName) {
        return null;
    }

    @Override
    public int insertProduct(Product product) {
        return 0;
    }

    @Override
    public int updateProduct(Product product) {
        return 0;
    }

    @Override
    public int deleteProduct(Integer productId) {
        return 0;
    }
}
