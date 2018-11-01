package com.example.crm.service;

import com.example.crm.entity.Opportunity;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:54
 * @ Description：机会业务逻辑接口
 * @ Modified By：
 */
public interface OpportunityService {
    List<Opportunity> getOpportunityList();

    Opportunity getOpportunity(Integer opportunityId);

    int insertOpportunity(Opportunity opportunity);

    int updateOpportunity(Opportunity opportunity);

    int deleteOpportunity(Integer opportunity);
}
