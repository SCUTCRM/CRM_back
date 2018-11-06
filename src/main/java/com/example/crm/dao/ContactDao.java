package com.example.crm.dao;

import com.example.crm.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 9:59
 * @ Description：联系人数据库访问层接口
 * @ Modified By：
 */
@Component
public interface ContactDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的联系人信息
     * create time: 2018/11/1 10:01
     *
     * @return
     * @Param: null
     */
    List<Contact> getContactList();

    /**
     * create by: Bin Liu
     * description: 根据id获取联系人信息
     * create time: 2018/11/1 10:18
     *
     * @return
     * @Param: null
     */
    Contact getContactById(Integer contactId);

    /**
     * create by: Bin Liu
     * description: 根据firstName获取联系人信息
     * create time: 2018/11/6 16:44
     *
     * @return
     * @Param: null
     */
    Contact getContactByFirstName(String firstName);

    /**
     * create by: Bin Liu
     * description: 根据lastName获取联系人信息
     * create time: 2018/11/6 16:44
     *
     * @return
     * @Param: null
     */
    Contact getContactByLastName(String lastName);

    /**
     * create by: Bin Liu
     * description: 根据title获取联系人信息
     * create time: 2018/11/6 16:44
     *
     * @return
     * @Param: null
     */
    Contact getContactByTitle(String title);

    /**
     * create by: Bin Liu
     * description: 根据OrganizationName获取联系人信息
     * create time: 2018/11/6 16:44
     *
     * @return
     * @Param: null
     */
    Contact getContactByOrganizationName(String organizationName);

    /**
     * create by: Bin Liu
     * description: 根据PrimaryEmail获取联系人信息
     * create time: 2018/11/6 16:57
     *
     * @return
     * @Param: null
     */
    Contact getContactByPrimaryEmail(String primaryEmail);

    /**
     * create by: Bin Liu
     * description: 根据OfficePhone获取联系人信息
     * create time: 2018/11/6 16:57
     *
     * @return
     * @Param: null
     */
    Contact getContactByOfficePhone(String officePhone);

    /**
     * create by: Bin Liu
     * description: 根据AssignedTo获取联系人信息
     * create time: 2018/11/6 16:57
     *
     * @return
     * @Param: null
     */
    Contact getContactByAssignTo(Integer assignTo);

    /**
     * create by: Bin Liu
     * description: 插入一个联系人信息
     * create time: 2018/11/1 10:01
     *
     * @return
     * @Param: null
     */
    int insertContact(Contact contact);

    /**
     * create by: Bin Liu
     * description: 更新一个联系人信息
     * create time: 2018/11/1 10:02
     *
     * @return
     * @Param: null
     */
    int updateContact(Contact contact);

    /**
     * create by: Bin Liu
     * description: 删除一个联系人信息
     * create time: 2018/11/1 10:02
     *
     * @return
     * @Param: null
     */
    int deleteContact(Integer contactId);

}
