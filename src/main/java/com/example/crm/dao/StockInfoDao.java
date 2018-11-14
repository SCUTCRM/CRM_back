package com.example.crm.dao;

import com.example.crm.entity.StockInfo;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/12 15:34
 * @ Description：库存数据库访问层接口
 * @ Modified By：
 */
@Component
public interface StockInfoDao {
    /**
     * create by: Bin Liu
     * description: 根据id获取指定库存信息
     * create time: 2018/11/12 15:35
     * @Param: null
     * @return
     */
    StockInfo getStockInfoById(Integer stockInfoId);

    /**
     * create by: Bin Liu
     * description: 增加一个库存信息
     * create time: 2018/11/12 15:35
     * @Param: null
     * @return
     */
    int insertStockInfo(StockInfo stockInfo);

    /**
     * create by: Bin Liu
     * description: 更新一个库存信息
     * create time: 2018/11/12 15:36
     * @Param: null
     * @return
     */
    int updateStockInfo(StockInfo stockInfo);

    /**
     * create by: Bin Liu
     * description: 根据Id删除库存信息
     * create time: 2018/11/12 15:36
     * @Param: null
     * @return
     */
    int deleteStockInfo(Integer stockInfoId);
    
    /**
     * create by: Bin Liu
     * description: 动态获取库存信息
     * create time: 2018/11/13 22:57
     * @Param: null
     * @return 
     */
    StockInfo getStockInfo(StockInfo stockInfo);
}
