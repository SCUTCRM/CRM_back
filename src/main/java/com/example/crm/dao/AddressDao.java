package com.example.crm.dao;

import com.example.crm.entity.Address;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 9:47
 * @ Description：地址数据库访问层接口
 * @ Modified By：
 */
@Component
public interface AddressDao {
    /**
     * create by: Bin Liu
     * description: 根据id获取指定地址信息
     * create time: 2018/11/1 9:52
     *
     * @return
     * @Param: null
     */
    Address getAddress(Integer addressId);

    /**
     * create by: Bin Liu
     * description: 增加一个地址
     * create time: 2018/11/1 9:55
     *
     * @return
     * @Param: null
     */
    int insertAddress(Address address);

    /**
     * create by: Bin Liu
     * description: 更新一个地址
     * create time: 2018/11/1 9:55
     *
     * @return
     * @Param: null
     */
    int updateAddress(Address address);

    /**
     * create by: Bin Liu
     * description: 根据Id删除地址信息
     * create time: 2018/11/1 9:54
     *
     * @return
     * @Param: null
     */
    int deleteAddress(Integer addressId);
}
