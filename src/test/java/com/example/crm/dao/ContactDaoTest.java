package com.example.crm.dao;

import com.example.crm.entity.Address;
import com.example.crm.entity.Contact;
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
 * @ Date       ：2018/11/4 11:52
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactDaoTest {
    @Autowired
    private ContactDao contactDao;

    @Test
    @Ignore
    public void getContactList() {
        System.out.println(contactDao.getContactList());
    }

    @Test
    @Ignore
    public void getContact() {
        System.out.println(contactDao.getContact(1));
    }

    @Test
    @Ignore
    public void insertContact() {
        Contact contact=new Contact();
        contact.setContactId(1);
        contact.setFirstName("刘");
        contact.setLastName("斌");
        contact.setTitle("学生");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        contact.setOrganization(organization);
        contact.setEmail("1145054472@qq.com");
        contact.setOfficePhone(788);
        contact.setIsFromLead("Y");
        contact.setHomePhone(7887227);
        contact.setAssignTo(1);
        Address address=new Address();
        address.setAddressId(1);
        contact.setAddress(address);
        contact.setUpdateInfo("插入Contact");
        contact.setLeadState(1);
        contact.setIndustry("教育");
        contact.setCreateTime(new Date());
        contact.setModifiedTime(new Date());
        contact.setDayOfBirth(new Date(1998,05,06));
        contact.setDepartment("华工软件");
        contact.setAssistant("林少辉");
        contact.setAssistantPhone(1576698);
        contact.setProfilePicture("c://picture");
        contact.setDescription("测试");
        System.out.println(contactDao.insertContact(contact));
    }

    @Test
    @Ignore
    public void updateContact() {
        Contact contact=new Contact();
        contact.setContactId(1);
        contact.setFirstName("刘");
        contact.setLastName("斌");
        contact.setTitle("学生");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        contact.setOrganization(organization);
        contact.setEmail("1145054472@qq.com");
        contact.setOfficePhone(788);
        contact.setIsFromLead("Y");
        contact.setHomePhone(788722);
        contact.setAssignTo(1);
        Address address=new Address();
        address.setAddressId(1);
        contact.setAddress(address);
        contact.setUpdateInfo("更改Contact");
        contact.setLeadState(1);
        contact.setIndustry("教育");
        contact.setCreateTime(new Date());
        contact.setModifiedTime(new Date());
        contact.setDayOfBirth(new Date(1998,05,06));
        contact.setDepartment("华工软件");
        contact.setAssistant("狗辉");
        contact.setAssistantPhone(1576698);
        contact.setProfilePicture("c://picture");
        contact.setDescription("测试");
        System.out.println(contactDao.updateContact(contact));
    }

    @Test
    @Ignore
    public void deleteContact() {
        System.out.println(contactDao.deleteContact(1));
    }
}