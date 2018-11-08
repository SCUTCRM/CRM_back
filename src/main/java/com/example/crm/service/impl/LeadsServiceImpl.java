package com.example.crm.service.impl;

import com.example.crm.dao.LeadsDao;
import com.example.crm.entity.Leads;
import com.example.crm.exception.LeadsException;
import com.example.crm.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 11:20
 * @ Description：线索业务逻辑实现类
 * @ Modified By：
 */
@Service
public class LeadsServiceImpl implements LeadsService {
    @Autowired
    private LeadsDao leadsDao;

    @Override
    public List<Leads> getLeadsList() {
        return leadsDao.getLeadsList();
    }

    @Override
    public Leads getLeads(Integer leadId) {
        return leadsDao.getLeadsById(leadId);
    }

    @Transactional
    @Override
    public int insertLeads(Leads leads) {
        if (leads == null) {
            return 0;
        }
        try {
            int result = leadsDao.insertLeads(leads);
            return result;
        } catch (Exception e) {
            throw new LeadsException("插入线索失败", -1);
        }
    }

    @Transactional
    @Override
    public int updateLeads(Leads leads) {
        if (leads == null || leads.getLeadId() == null) {
            return 0;
        }
        try {
            int result = leadsDao.updateLeads(leads);
            return result;
        } catch (Exception e) {
            throw new LeadsException("更新线索失败", -1);
        }
    }

    @Transactional
    @Override
    public int deleteLeads(Integer leadId) {
        if (leadId == null) {
            return 0;
        }
        try {
            int result = leadsDao.deleteLeads(leadId);
            return result;
        } catch (Exception e) {
            throw new LeadsException("删除线索失败", -2);
        }
    }

    @Override
    public List<Leads> getRecentlyModified() {
        return leadsDao.getRecentlyModified();
    }

    @Override
    public Leads getLeadsByFirstName(String firstName) {
        return leadsDao.getLeadsByFirstName(firstName);
    }

    @Override
    public Leads getLeadsByLastName(String lastName) {
        return leadsDao.getLeadsByLastName(lastName);
    }

    @Override
    public Leads getLeadsByCompany(String company) {
        return leadsDao.getLeadsByCompany(company);
    }

    @Override
    public Leads getLeadsByPrimaryPhone(Integer primaryPhone) {
        return leadsDao.getLeadsByPrimaryPhone(primaryPhone);
    }

    @Override
    public Leads getLeadsByWebsite(String website) {
        return leadsDao.getLeadsByWebsite(website);
    }

    @Override
    public Leads getLeadsByPrimaryEmail(String primaryEmail) {
        return leadsDao.getLeadsByPrimaryEmail(primaryEmail);
    }

    @Override
    public Leads getLeadsByAssignTo(Integer assignTo) {
        return leadsDao.getLeadsByAssignTo(assignTo);
    }


}
