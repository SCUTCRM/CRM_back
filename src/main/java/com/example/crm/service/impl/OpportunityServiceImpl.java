package com.example.crm.service.impl;

import com.example.crm.dao.OpportunityDao;
import com.example.crm.dto.OpportunityDto;
import com.example.crm.entity.Opportunity;
import com.example.crm.exception.OpportunityException;
import com.example.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 11:25
 * @ Description：机会业务逻辑实现类
 * @ Modified By：
 */
@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpportunityDao opportunityDao;

    @Override
    public List<Opportunity> getOpportunityList() {
        return opportunityDao.getOpportunityList();
    }

    @Override
    public Opportunity getOpportunityById(Integer opportunityId) {
        return opportunityDao.getOpportunityById(opportunityId);
    }

    @Override
    public List<OpportunityDto> getOpportunity(Opportunity opportunity) {
        List<Opportunity> opportunityList=opportunityDao.getOpportunity(opportunity);
        List<OpportunityDto> opportunities = new ArrayList<>();
        for (Opportunity o : opportunityList) {
            OpportunityDto oto = new OpportunityDto();
            oto.setOpportunityName(o.getOpportName());
            oto.setOrganizationName(o.getContact().getOrganization().getOrganizationName());
            oto.setSalesStage(o.getSalesStage());
            oto.setLeadSource(o.getLeadSource());
            oto.setExpectedCloseDate(o.getExpectedCloseDate());
            oto.setAmount(o.getForcastAmount());
            oto.setAssignTo(o.getAssignTo());
            oto.setContactName(o.getContact().getFirstName());
            opportunities.add(oto);
        }
        return opportunities;
    }
    @Transactional
    @Override
    public int insertOpportunity(Opportunity opportunity) {
        if (opportunity == null) {
            return 0;
        }
        try {
            int result = opportunityDao.insertOpportunity(opportunity);
            return result;
        } catch (Exception e) {
            throw new OpportunityException("插入机会失败", -1);
        }
    }

    @Transactional
    @Override
    public int updateOpportunity(Opportunity opportunity) {
        if (opportunity == null || opportunity.getOpportId() == null) {
            return 0;
        }
        try {
            int result = opportunityDao.updateOpportunity(opportunity);
            return result;
        } catch (Exception e) {
            throw new OpportunityException("更新机会失败", -1);
        }
    }

    @Transactional
    @Override
    public int deleteOpportunity(Integer opportunityId) {
        if (opportunityId == null) {
            return 0;
        }
        try {
            int result = opportunityDao.deleteOpportunity(opportunityId);
            return result;
        } catch (Exception e) {
            throw new OpportunityException("删除机会失败", -2);
        }
    }

    @Override
    public List<Opportunity> getRecentlyModified() {
        return opportunityDao.getRecentlyModified();
    }

    @Override
    public Opportunity getOpportunityByContactId(Integer contactId) {
        return opportunityDao.getOpportunityByContactId(contactId);
    }
}
