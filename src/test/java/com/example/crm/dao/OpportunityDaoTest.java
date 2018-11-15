package com.example.crm.dao;

import com.example.crm.entity.Contact;
import com.example.crm.entity.Document;
import com.example.crm.entity.Opportunity;
import com.example.crm.entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:53
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityDaoTest {
    @Autowired
    private OpportunityDao opportunityDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private ContactDao contactDao;

    @Test
    //@Ignore
    public void getOpportunityList() {
        System.out.println(opportunityDao.getOpportunityList());
    }

    @Test
    //@Ignore
    public void getOpportunityById() {
        System.out.println(opportunityDao.getOpportunityById(1));
    }

    @Test
    //@Ignore
    public void insertOpportunity() {
        Opportunity opportunity = new Opportunity();
        opportunity.setOpportId(1);
        opportunity.setOpportName("offor");
        opportunity.setSalesStage("开始阶段");
        opportunity.setProb(11.0);
        opportunity.setForcastAmount(11.0);
        opportunity.setIsFromLead("Y");
        opportunity.setAssignTo(1);
        Contact contact = new Contact();
        contact.setContactId(1);
        opportunity.setContact(contact);
        opportunity.setLeadSource("手册");
        opportunity.setUpdateInfo("插入机会");
        opportunity.setCreateTime(new Date());
        opportunity.setModifiedTime(new Date());
        opportunity.setOpportType("工作");
        opportunity.setExpectedCloseDate(new Date());
        opportunity.setDescription("测试");
        Document document=new Document();
        document.setDocumentId(1);
        opportunity.setDocument(document);
        System.out.println(opportunityDao.insertOpportunity(opportunity));
    }

    @Test
    //@Ignore
    public void updateOpportunity() {
        Opportunity opportunity = opportunityDao.getOpportunityById(2);
        opportunity.setOpportName("offor");
        opportunity.setProb(11.0);
        opportunity.setSalesStage("结束阶段");
        opportunity.setForcastAmount(11.0);
        opportunity.setIsFromLead("Y");
        opportunity.setAssignTo(1);
        Contact contact = new Contact();
        contact.setContactId(1);
        opportunity.setContact(contact);
        opportunity.setLeadSource("手册");
        opportunity.setUpdateInfo("更改机会");
        opportunity.setCreateTime(new Date());
        opportunity.setModifiedTime(new Date());
        opportunity.setOpportType("工作");
        opportunity.setExpectedCloseDate(new Date());
        opportunity.setDescription("测试");
        Document document=new Document();
        document.setDocumentId(1);
        opportunity.setDocument(document);
        System.out.println(opportunityDao.updateOpportunity(opportunity));
    }

    @Test
    //@Ignore
    public void deleteOpportunity() {
        System.out.println(opportunityDao.deleteOpportunity(2));
    }

    @Test
    //@Ignore
    public void getUpdateInfo() {
        System.out.println(opportunityDao.getUpdateInfo(1));
    }

    @Test
    //@Ignore
    public void getOpportunity() {
        Opportunity opportunity = new Opportunity();
        opportunity.setOpportName("offer");
        String organizationName = "华工";
        Organization organization = organizationDao.getOrganizationByName(organizationName);
        Contact contact=contactDao.getContactByOrganizationId(organization.getOrganizationId());
        opportunity.setContact(contact);
        opportunity.setSalesStage("结束阶段");
        opportunity.setLeadSource("手册");
        opportunity.setForcastAmount(11.0);
        opportunity.setAssignTo(1);
        System.out.println(opportunityDao.getOpportunityById(1));
    }

    @Test
    //@Ignore
    public void getOpportunityByContactId() {
        Integer productId=1;
        Organization organization=organizationDao.getOrganizationByProductId(productId);
        Contact contact= contactDao.getContactByOrganizationId(organization.getOrganizationId());
        System.out.println(opportunityDao.getOpportunityByContactId(contact.getContactId()));
    }
}