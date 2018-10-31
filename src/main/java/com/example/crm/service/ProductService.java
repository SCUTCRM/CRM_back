package com.example.crm.service;

import com.example.crm.entity.Product;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:14
 * @ Description：产品业务逻辑接口
 * @ Modified By：
 */
public interface ProductService {
    /**
     * create by: Bin Liu
     * description: 获取一条产品信息
     * create time: 2018/10/31 20:17
     * @Param: null
     * @return 
     */
    Product getProduct(String productName);

    /**
     * create by: Bin Liu
     * description: 插入一条产品信息
     * create time: 2018/10/31 20:20
     * @Param: null
     * @return 
     */
    int insertProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 更新一条产品信息
     * create time: 2018/10/31 20:20
     * @Param: null
     * @return 
     */
    int updateProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 删除一条产品信息
     * create time: 2018/10/31 20:20
     * @Param: null
     * @return 
     */
    int deleteProduct(Integer productId);
}
