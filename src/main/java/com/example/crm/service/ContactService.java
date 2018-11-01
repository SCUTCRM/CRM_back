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

    Contact getContact(Integer contactId);

    int insertContact(Contact contact);

    int updateContact(Contact contact);

    int deleteContact(Integer contactId);
}
