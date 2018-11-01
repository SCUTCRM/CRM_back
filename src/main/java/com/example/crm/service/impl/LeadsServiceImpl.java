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
        return leadsDao.getLeads(leadId);
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
}
