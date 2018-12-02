package com.example.crm.service.impl;

import com.example.crm.dao.CampaignDao;
import com.example.crm.dto.CampaignDto;
import com.example.crm.entity.Campaign;
import com.example.crm.exception.CampaignException;
import com.example.crm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:57
 * @ Description：活动业务逻辑实现类
 * @ Modified By：
 */
@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignDao campaignDao;

    @Override
    public List<Campaign> getCampaignList() {
        return campaignDao.getCampaignList();
    }

    @Override
    public Campaign getCampaignById(Integer campaignId) {
        return campaignDao.getCampaignById(campaignId);
    }

    @Override
    public List<CampaignDto> getCampaign(Campaign campaign) {
        List<Campaign> campaignList=campaignDao.getCampaign(campaign);
        List<CampaignDto> campaigns = new ArrayList<>();
        for (Campaign c : campaignList) {
            CampaignDto dto = new CampaignDto();
            dto.setCampaignName(c.getCampaignName());
            dto.setCampaignType(c.getCampaignType());
            dto.setCampaignStatus(c.getCampaignStatus());
            dto.setExpectedRevenue(c.getExpectedRevenue());
            dto.setExpectedCloseDate(c.getExpectedCloseDate());
            dto.setAssignTo(c.getAssignTo());
            campaigns.add(dto);
        }
        return campaigns;
    }

    @Transactional
    @Override
    public int insertCampaign(Campaign campaign) {
        if (campaign == null) {
            return 0;
        }
        try {
            int result = campaignDao.insertCampaign(campaign);
            return result;
        } catch (Exception e) {
            throw new CampaignException("插入活动失败", -1);
        }
    }

    @Transactional
    @Override
    public int updateCampaign(Campaign campaign) {
        if (campaign == null || campaign.getCampaignId() == null) {
            return 0;
        }
        try {
            int result = campaignDao.updateCampaign(campaign);
            return result;
        } catch (Exception e) {
            throw new CampaignException("更新活动失败", -1);
        }
    }

    @Transactional
    @Override
    public int deleteCampaign(Integer campaignId) {
        if (campaignId == null) {
            return 0;
        }
        try {
            int result = campaignDao.deleteCampaign(campaignId);
            return result;
        } catch (Exception e) {
            throw new CampaignException("删除活动失败", -2);
        }
    }

    @Override
    public List<Campaign> getRecentlyModified() {
        return campaignDao.getRecentlyModified();
    }

    @Override
    public Campaign getUpdateInfo(Integer campaignId) {
        return campaignDao.getUpdateInfo(campaignId);
    }

    @Override
    public Campaign getCampaignByProductId(Integer productId) {
        return campaignDao.getCampaignByProductId(productId);
    }

}
