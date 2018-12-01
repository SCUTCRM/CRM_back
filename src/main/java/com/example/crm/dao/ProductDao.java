package com.example.crm.dao;

import com.example.crm.entity.Contact;
import com.example.crm.entity.Opportunity;
import com.example.crm.entity.Organization;
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
     * description: 动态获取product
     * create time: 2018/11/8 23:19
     * @Param: null
     * @return 
     */
    List<Product> getProduct(Product product);
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
     * description: 获取最近更新信息
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
    List<Product> findDuplicates(List<Object> list);

    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/6 22:40
     * @Param: null
     * @return 
     */
    Product getUpdateInfo(Integer productId);

    /**
     * create by: Bin Liu
     * description: 根据organizationId获取产品信息
     * create time: 2018/11/17 15:49
     * @Param: null
     * @return 
     */
    Product getProductByOrganizationId(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 通过productId获取产品的父类信息
     * create time: 2018/11/20 18:57
     * @Param: null
     * @return 
     */
    Product getParentProduct(int productId);

    /**
     * create by: Bin Liu
     * description: 通过productId获取产品的绑定信息
     * create time: 2018/11/20 18:57
     * @Param: null
     * @return
     */
    Product getBundleProduct(int productId);
 }
