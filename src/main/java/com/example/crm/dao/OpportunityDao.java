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
    Opportunity getOpportunityById(Integer opportunityId);

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

    /**
     * create by: Bin Liu
     * description: 获取最近更新信息
     * create time: 2018/11/6 22:48
     * @Param: null
     * @return
     */
    List<Opportunity> getRecentlyModified();
    
    /**
     * create by: Bin Liu
     * description: 动态获取更新信息
     * create time: 2018/11/8 22:37
     * @Param: null
     * @return 
     */
    Opportunity getOpportunity(Opportunity opportunity);

    /**
     * create by: Bin Liu
     * description: 获取更新信息
     * create time: 2018/11/12 23:12
     * @Param: null
     * @return
     */
    Opportunity getUpdateInfo(Integer opportId);

    /**
     * create by: Bin Liu
     * description: 根据contactId获取机会信息
     * create time: 2018/11/14 21:29
     * @Param: null
     * @return 
     */
    Opportunity getOpportunityByContactId(Integer contactId);
}
