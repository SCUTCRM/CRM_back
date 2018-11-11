package com.example.crm.dao;

import com.example.crm.entity.Address;
import com.example.crm.entity.Organization;
import org.junit.Ignore;
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
public class OrganizationDaoTest {
    @Autowired
    private OrganizationDao organizationDao;

    @Test
    @Ignore
    public void getOrganizationList() {
        System.out.println(organizationDao.getOrganizationList());
    }

    @Test
    //@Ignore
    public void getOrganization() {
        System.out.println(organizationDao.getOrganizationById(1));
    }

    @Test
    @Ignore
    public void insertOrganization() {
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        organization.setOrganizationName("华工");
        organization.setBillingCity("广州");
        organization.setWebsite("www.scut.edu.cn");
        organization.setPrimaryPhone(123456);
        organization.setAssignTo(1);
        organization.setUpdateInfo("插入组织");
        organization.setIsFromLead("Y");
        organization.setOwnerShip("教育部");
        organization.setAnnualRevenue(1000000.0);
        organization.setMemberOf("软件学院");
        organization.setEmployee("老师");
        organization.setIndustry("教育");
        organization.setModifiedTime(new Date());
        organization.setCreateTime(new Date());
        Address address=new Address();
        address.setAddressId(1);
        organization.setAddress(address);
        organization.setDescription("测试");
        System.out.println(organizationDao.insertOrganization(organization));
    }

    @Test
    //@Ignore
    public void updateOrganization() {
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        organization.setOrganizationName("华工");
        organization.setBillingCity("广州");
        organization.setWebsite("www.scut.edu.cn");
        organization.setPrimaryPhone(123456);
        organization.setAssignTo(1);
        organization.setUpdateInfo("修改组织");
        organization.setIsFromLead("Y");
        organization.setOwnerShip("教育部");
        organization.setAnnualRevenue(1000000.0);
        organization.setMemberOf("软件学院");
        organization.setEmployee("老师");
        organization.setIndustry("教育");
        organization.setModifiedTime(new Date());
        organization.setCreateTime(new Date());
        Address address=new Address();
        address.setAddressId(1);
        organization.setAddress(address);
        organization.setDescription("测试");
        System.out.println(organizationDao.updateOrganization(organization));
    }

    @Test
    @Ignore
    public void deleteOrganization() {
        System.out.println(organizationDao.deleteOrganization(1));
    }
}