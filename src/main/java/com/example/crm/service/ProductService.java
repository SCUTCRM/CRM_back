package com.example.crm.service;

import com.example.crm.entity.Product;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:14
 * @ Description：产品业务逻辑接口
 * @ Modified By：
 */
public interface ProductService {
    /**
     * create by: Bin Liu
     * description: 获取所有的产品信息
     * create time: 2018/11/1 10:59
     *
     * @return
     * @Param: null
     */
    List<Product> getProductList();

    /**
     * create by: Bin Liu
     * description: 获取一条产品信息
     * create time: 2018/10/31 20:17
     *
     * @return
     * @Param: null
     */
    Product getProductById(Integer productId);

    /**
     * create by: Bin Liu
     * description: 根据用户商品productName查询商品
     * create time: 2018/11/6 15:45
     * @Param: null
     * @return 
     */
    Product getProductByProductName(String productProductName);

    /**
     * create by: Bin Liu
     * description: 根据用户商品partNumber查询商品
     * create time: 2018/11/6 15:45
     * @Param: null
     * @return 
     */
    Product getProductByPartNumber(Integer partNumber);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的佣金率查询商品
     * create time: 2018/11/6 15:45
     * @Param: null
     * @return 
     */
    Product getProductByCommissionRate(Double commissionRate);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的库存数量查询商品
     * create time: 2018/11/6 15:45
     * @Param: null
     * @return 
     */
    Product getProductByQtyInStock(Integer qtyInStock);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的数量/单位查询商品
     * create time: 2018/11/6 15:45
     * @Param: null
     * @return 
     */
    Product getProductByQtyUnit(Integer unit);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的单价查询商品
     * create time: 2018/11/6 15:46
     * @Param: null
     * @return 
     */
    Product getProductByUnitPrice(Double unitPrice);
    /**
     * create by: Bin Liu
     * description: 插入一条产品信息
     * create time: 2018/10/31 20:20
     *
     * @return
     * @Param: null
     */
    int insertProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 更新一条产品信息
     * create time: 2018/10/31 20:20
     *
     * @return
     * @Param: null
     */
    int updateProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 删除一条产品信息
     * create time: 2018/10/31 20:20
     *
     * @return
     * @Param: null
     */
    int deleteProduct(Integer productId);
}
