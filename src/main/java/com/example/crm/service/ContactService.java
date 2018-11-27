package com.example.crm.service;

import com.example.crm.entity.Contact;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:48
 * @ Description：联系人业务逻辑接口
 * @ Modified By：
 */
public interface ContactService {
    List<Contact> getContactList();

    Contact getContactById(Integer contactId);

    List<Contact> getContact(Contact contact);

    Contact getContactByOrganizationId(Integer organizationId);

    int insertContact(Contact contact);

    int updateContact(Contact contact);

    int deleteContact(Integer contactId);

    List<Contact> getRecentlyModified();

    Contact getUpdateInfo(Integer contactId);
}
