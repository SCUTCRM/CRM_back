package com.example.crm.service;

import com.example.crm.dao.CampaignDao;
import com.example.crm.entity.Campaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:55
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CampaignServiceImplTest {
    @Autowired
    private CampaignDao campaignDao;

    @Test
    public void getCampaignList() {
        List<Campaign> list=campaignDao.getCampaignList();
        System.out.println(list.get(0));
    }

    @Test
    public void getCampaign() {
    }

    @Test
    public void insertCampaign() {
    }

    @Test
    public void updateCampaign() {
    }

    @Test
    public void deleteCampaign() {
    }
}