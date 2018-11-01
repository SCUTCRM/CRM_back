package com.example.crm.dao;

import com.example.crm.entity.Price;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:22
 * @ Description：价格数据库访问层接口
 * @ Modified By：
 */
@Component
public interface PriceDao {
    /**
     * create by: Bin Liu
     * description: 获取一条价格信息
     * create time: 2018/11/1 10:24
     *
     * @return
     * @Param: null
     */
    Price getPrice(Integer priceId);

    /**
     * create by: Bin Liu
     * description: 插入一条价格信息
     * create time: 2018/11/1 10:24
     *
     * @return
     * @Param: null
     */
    int insertPrice(Price price);

    /**
     * create by: Bin Liu
     * description: 更新一条价格信息
     * create time: 2018/11/1 10:24
     *
     * @return
     * @Param: null
     */
    int updatePrice(Price price);

    /**
     * create by: Bin Liu
     * description: 删除一条价格信息
     * create time: 2018/11/1 10:24
     *
     * @return
     * @Param: null
     */
    int deletePrice(Integer priceId);
}
