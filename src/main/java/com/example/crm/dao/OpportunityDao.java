package com.example.crm.dao;

import com.example.crm.entity.Opportunity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:12
 * @ Description：机会数据库访问层接口
 * @ Modified By：
 */
@Component
public interface OpportunityDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的机会信息
     * create time: 2018/11/1 10:15
     * @Param: null
     * @return
     */
    List<Opportunity> getOpportunityList();

    /**
     * create by: Bin Liu
     * description: 根据id获取机会信息
     * create time: 2018/11/1 10:15
     * @Param: null
     * @return
     */
    Opportunity getOpportunity(Integer opportunityId);

    /**
     * create by: Bin Liu
     * description: 插入一条机会信息
     * create time: 2018/11/1 10:16
     * @Param: null
     * @return
     */
    int insertOpportunity(Opportunity opportunity);

    /**
     * create by: Bin Liu
     * description: 更新一条机会信息
     * create time: 2018/11/1 10:16
     * @Param: null
     * @return
     */
    int updateOpportunity(Opportunity opportunity);

    /**
     * create by: Bin Liu
     * description: 删除一条机会信息
     * create time: 2018/11/1 10:16
     * @Param: null
     * @return
     */
    int deleteOpportunity(Integer opportunity);
}
