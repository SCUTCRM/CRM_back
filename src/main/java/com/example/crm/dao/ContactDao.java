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
    Contact getContact(Integer contactId);

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
