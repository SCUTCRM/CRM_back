package com.example.crm.service;

import com.example.crm.entity.Leads;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:53
 * @ Description：线索业务逻辑接口
 * @ Modified By：
 */
public interface LeadsService {
    List<Leads> getLeadsList();

    Leads getLeads(Integer leadId);

    int insertLeads(Leads leads);

    int updateLeads(Leads leads);

    int deleteLeads(Integer leadId);

    List<Leads> getRecentlyModified();

    Leads getLeads(Leads leads);
}
