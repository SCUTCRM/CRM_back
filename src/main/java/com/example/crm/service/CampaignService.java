package com.example.crm.service;

import com.example.crm.entity.Campaign;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:44
 * @ Description：活动业务逻辑接口
 * @ Modified By：
 */
public interface CampaignService {
    List<Campaign> getCampaignList();

    Campaign getCampaign(Integer campaignId);

    int insertCampaign(Campaign campaign);

    int updateCampaign(Campaign campaign);

    int deleteCampaign(Integer campaignId);

    List<Campaign> getRecentlyModified();
}
