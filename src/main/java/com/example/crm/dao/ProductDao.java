package com.example.crm.dao;

import com.example.crm.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 19:32
 * @ Description：产品数据库访问层接口
 * @ Modified By：
 */
@Component
public interface ProductDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的产品信息
     * create time: 2018/11/1 9:53
     *
     * @return
     * @Param: null
     */
    List<Product> getProductList();

    /**
     * create by: Bin Liu
     * description: 根据用户商品Id查询商品
     * create time: 2018/10/31 19:46
     *
     * @return
     * @Param: null
     */
    Product getProductById(Integer productId);

    /**
     * create by: Bin Liu
     * description: 根据用户商品productName查询商品
     * create time: 2018/11/6 15:27
     *
     * @return
     * @Param: null
     */
    Product getProductByProductName(String productName);

    /**
     * create by: Bin Liu
     * description: 根据用户商品partNumber查询商品
     * create time: 2018/11/6 15:32
     *
     * @return
     * @Param: null
     */
    Product getProductByPartNumber(Integer partNumber);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的佣金率查询商品
     * create time: 2018/11/6 15:33
     *
     * @return
     * @Param: null
     */
    Product getProductByCommissionRate(Double commissionRate);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的库存数量查询商品
     * create time: 2018/11/6 15:36
     *
     * @return
     * @Param: null
     */
    Product getProductByQtyInStock(Integer qtyInStock);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的数量/单位查询商品
     * create time: 2018/11/6 15:37
     *
     * @return
     * @Param: null
     */
    Product getProductByQtyUnit(Integer unit);

    /**
     * create by: Bin Liu
     * description: 根据用户商品的单价查询商品
     * create time: 2018/11/6 15:37
     * @Param: null
     * @return
     */
    Product getProductByUnitPrice(Double unitPrice);
    /**
     * create by: Bin Liu
     * description: 增加一个产品
     * create time: 2018/10/31 19:52
     *
     * @return
     * @Param: null
     */
    int insertProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 更新一个产品
     * create time: 2018/10/31 19:52
     *
     * @return
     * @Param: null
     */
    int updateProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 根据id删除一个产品
     * create time: 2018/10/31 19:51
     *
     * @return
     * @Param: null
     */
    int deleteProduct(Integer productId);

    /**
     * create by: Bin Liu
     * description: 获取最近修改的产品信息
     * create time: 2018/11/6 21:57
     * @Param: null
     * @return 
     */
    List<Product> getRecentlyModified();

    /**
     * create by: Bin Liu
     * description: 查重
     * create time: 2018/11/6 22:07
     * @Param: null
     * @return 
     */
    int findDuplicates();

    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/6 22:40
     * @Param: null
     * @return 
     */
    String getUpdateInfo(Integer productId);
 }
