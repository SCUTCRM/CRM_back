package com.example.crm.dao;

import com.example.crm.entity.Campaign;
import com.example.crm.entity.ExpActual;
import com.example.crm.entity.Opportunity;
import com.example.crm.entity.Product;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:52
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CampaignDaoTest {
    @Autowired
    private CampaignDao campaignDao;

    @Test
    //@Ignore
    public void getCampaignList() {
        System.out.println(campaignDao.getCampaignList());
    }

    @Test
    //@Ignore
    public void getCampaign() {
        System.out.println(campaignDao.getCampaignById(1));
    }

    @Test
    //@Ignore
    public void insertCampaign() {
        Campaign campaign=new Campaign();
        campaign.setCampaignType("篮球");
        campaign.setCampaignName("篮球活动");
        campaign.setCampaignStatus(1);
        campaign.setExpectedRevenue(100.0);
        campaign.setExpectedCloseDate(new Date());
        campaign.setAssignTo(1);
        Product product=new Product();
        product.setProductId(1);
        campaign.setProduct(product);
        campaign.setTargetSize(1);
        campaign.setNumSent(1);
        campaign.setTargetAudience("刘斌");
        campaign.setCreateTime(new Date());
        campaign.setModifiedTime(new Date());
        campaign.setSponsor(100);
        campaign.setDescription("测试");
        campaign.setUpdateInfo("测试插入");
        ExpActual expActual=new ExpActual();
        expActual.setExpActualId(1);
        campaign.setExpActual(expActual);
        Opportunity opportunity= new Opportunity();
        opportunity.setOpportId(1);
        campaign.setOpportunity(opportunity);
        System.out.println(campaignDao.insertCampaign(campaign));
    }

    @Test
    //@Ignore
    public void updateCampaign() {
        Campaign campaign=campaignDao.getCampaignById(2);
        campaign.setCampaignType("足球");
        campaign.setCampaignName("足球活动");
        campaign.setCampaignStatus(1);
        campaign.setExpectedRevenue(100.0);
        campaign.setExpectedCloseDate(new Date());
        campaign.setAssignTo(1);
        campaign.setProduct(new Product());
        campaign.setTargetSize(1);
        campaign.setNumSent(1);
        campaign.setTargetAudience("Liu Bin");
        campaign.setCreateTime(new Date());
        campaign.setModifiedTime(new Date());
        campaign.setSponsor(100);
        campaign.setDescription("测试");
        campaign.setUpdateInfo("测试更改");
        campaign.setExpActual(new ExpActual());
        campaign.setOpportunity(new Opportunity());
        System.out.println(campaignDao.updateCampaign(campaign));
    }

    @Test
    //@Ignore
    public void deleteCampaign() {
        System.out.println(campaignDao.deleteCampaign(2));
    }
}