package com.example.crm.dao;

import com.example.crm.entity.Address;
import com.example.crm.entity.Leads;
import com.example.crm.entity.Organization;
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
 * @ Date       ：2018/11/4 11:53
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeadsDaoTest {
    @Autowired
    private LeadsDao leadsDao;

    @Test
    @Ignore
    public void getLeadsList() {
        System.out.println(leadsDao.getLeadsList());
    }

    @Test
    //@Ignore
    public void getLeads() {
        System.out.println(leadsDao.getLeadsById(1));
    }

    @Test
    @Ignore
    public void insertLeads() {
        Leads leads=new Leads();
        leads.setFirstName("刘");
        leads.setLastName("斌");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        leads.setOrganization(organization);
        leads.setPrimaryPhone(1576634545);
        leads.setWebsite("www.baidu.com");
        leads.setPrimaryEmail("1145054472@qq.com");
        leads.setAssignTo(1);
        Product product=new Product();
        product.setProductId(1);
        leads.setProduct(product);
        leads.setAnnualRevenue(100.0);
        leads.setPhone(7887227);
        leads.setEmail("liubin2018v@gmail.com");
        Address address=new Address();
        address.setAddressId(1);
        leads.setAddress(address);
        leads.setUpdateInfo("插入潜在客户");
        leads.setDescription("测试");
        leads.setCreateTime(new Date());
        leads.setModifiedTime(new Date());
        System.out.println(leadsDao.insertLeads(leads));
    }

    @Test
    @Ignore
    public void updateLeads() {
        Leads leads=new Leads();
        leads.setFirstName("刘");
        leads.setLastName("斌");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        leads.setOrganization(organization);
        leads.setPrimaryPhone(1576634545);
        leads.setWebsite("www.baidu.com");
        leads.setPrimaryEmail("1145054472@qq.com");
        leads.setAssignTo(1);
        Product product=new Product();
        product.setProductId(1);
        leads.setProduct(product);
        leads.setAnnualRevenue(2000.0);
        leads.setPhone(7887227);
        leads.setEmail("liubin2018v@gmail.com");
        Address address=new Address();
        address.setAddressId(1);
        leads.setAddress(address);
        leads.setUpdateInfo("更改潜在客户");
        leads.setDescription("测试");
        leads.setCreateTime(new Date());
        leads.setModifiedTime(new Date());
        System.out.println(leadsDao.updateLeads(leads));
    }

    @Test
    @Ignore
    public void deleteLeads() {
        System.out.println(leadsDao.deleteLeads(1));
    }
}