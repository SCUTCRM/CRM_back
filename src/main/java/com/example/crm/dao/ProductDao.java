package com.example.crm.dao;

import com.example.crm.entity.Product;
import org.springframework.stereotype.Component;

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
     * description: 根据用户商品名称查询商品
     * create time: 2018/10/31 19:46
     * @Param: null
     * @return
     */
    Product getProduct(String productName);

    /**
     * create by: Bin Liu
     * description: 增加一个产品
     * create time: 2018/10/31 19:52
     * @Param: null
     * @return
     */
    int insertProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 更新一个产品
     * create time: 2018/10/31 19:52
     * @Param: null
     * @return 
     */
    int updateProduct(Product product);

    /**
     * create by: Bin Liu
     * description: 根据id删除一个产品
     * create time: 2018/10/31 19:51
     * @Param: null
     * @return 
     */
    int deleteProduct(Integer productId);


}
