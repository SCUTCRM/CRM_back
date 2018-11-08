package com.example.crm.service.impl;

import com.example.crm.dao.ContactDao;
import com.example.crm.entity.Contact;
import com.example.crm.exception.CampaignException;
import com.example.crm.exception.ContactException;
import com.example.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 11:11
 * @ Description：联系人业务逻辑实现类
 * @ Modified By：
 */
@Service
public class ContatcServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> getContactList() {
        return contactDao.getContactList();
    }

    @Override
    public Contact getContactById(Integer contactId) {
        return contactDao.getContactById(contactId);
    }

    @Override
    public Contact getContactByFirstName(String firstName) {
        return contactDao.getContactByFirstName(firstName);
    }

    @Override
    public Contact getContactByLastName(String lastName) {
        return contactDao.getContactByLastName(lastName);
    }

    @Override
    public Contact getContactByTitle(String title) {
        return contactDao.getContactByTitle(title);
    }

    @Override
    public Contact getContactByOrganizationName(String organizationName) {
        return contactDao.getContactByOrganizationName(organizationName);
    }

    @Override
    public Contact getContactByPrimaryEmail(String primaryEmail) {
        return contactDao.getContactByPrimaryEmail(primaryEmail);
    }

    @Override
    public Contact getContactByOfficePhone(String officePhone) {
        return contactDao.getContactByOfficePhone(officePhone);
    }

    @Override
    public Contact getContactByAssignTo(Integer assignTo) {
        return contactDao.getContactByAssignTo(assignTo);
    }


    @Transactional
    @Override
    public int insertContact(Contact contact) {
        if(contact == null){
            return 0;
        }
        try {
            int result=contactDao.insertContact(contact);
            return result;
        }catch (Exception e){
            throw new ContactException("插入联系人失败",-1);
        }
    }

    @Transactional
    @Override
    public int updateContact(Contact contact) {
        if (contact == null || contact.getContactId() == null) {
            return 0;
        }
        try {
            int result = contactDao.updateContact(contact);
            return result;
        } catch (Exception e) {
            throw new CampaignException("更新联系人失败", -1);
        }
    }

    @Transactional
    @Override
    public int deleteContact(Integer contactId) {
        if (contactId == null) {
            return 0;
        }
        try {
            int result = contactDao.deleteContact(contactId);
            return result;
        } catch (Exception e) {
            throw new CampaignException("删除联系人失败", -2);
        }
    }

    @Override
    public List<Contact> getRecentlyModified() {
        return contactDao.getRecentlyModified();
    }
}
