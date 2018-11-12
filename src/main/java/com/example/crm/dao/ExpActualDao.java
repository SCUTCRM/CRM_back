package com.example.crm.dao;

import com.example.crm.entity.ExpActual;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/11 22:08
 * @ Description：预测和实际数据库访问层接口
 * @ Modified By：
 */
@Component
public interface ExpActualDao {
    /**
     * create by: Bin Liu
     * description: 根据id获取指定预测和实际信息
     * create time: 2018/11/11 22:12
     * @Param: null
     * @return
     */
    ExpActual getExpActual(Integer expActualId);

    /**
     * create by: Bin Liu
     * description: 增加一个预测和实际信息
     * create time: 2018/11/11 22:12
     * @Param: null
     * @return
     */
    int insertExpActual(ExpActual expActual);

    /**
     * create by: Bin Liu
     * description: 更新一个预测和实际信息
     * create time: 2018/11/11 22:13
     * @Param: null
     * @return
     */
    int updateExpActual(ExpActual expActual);

    /**
     * create by: Bin Liu
     * description: 根据Id删除预测和实际信息
     * create time: 2018/11/11 22:13
     * @Param: null
     * @return
     */
    int deleteExpActual(Integer expActualId);
}
