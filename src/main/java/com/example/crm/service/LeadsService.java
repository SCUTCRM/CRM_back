package com.example.crm.service;

import com.example.crm.dto.LeadsDto;
import com.example.crm.entity.Campaign;
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

    Leads getLeadsById(Integer leadId);

    int insertLeads(Leads leads);

    int updateLeads(Leads leads);

    int deleteLeads(Integer leadId);

    List<Leads> getRecentlyModified();

    List<LeadsDto> getLeads(Leads leads);

    Leads getUpdateInfo(Integer leadsId);

    Leads getLeadsByProductId(Integer productId);

}
