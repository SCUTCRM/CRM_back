package com.example.crm.service;

import com.example.crm.entity.Organization;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:14
 * @ Description：${description}
 * @ Modified By：
 */
public interface OrganizationService {
    /**
     * create by: Bin Liu
     * description: 获取所有的组织信息
     * create time: 2018/11/1 10:58
     *
     * @return
     * @Param: null
     */
    List<Organization> getOrganizationList();

    /**
     * create by: Bin Liu
     * description: 获取一条组织信息
     * create time: 2018/10/31 20:21
     *
     * @return
     * @Param: null
     */
    Organization getOrganization(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 插入一条组织信息
     * create time: 2018/10/31 20:22
     *
     * @return
     * @Param: null
     */
    int insertOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 更新一条组织信息
     * create time: 2018/10/31 20:22
     *
     * @return
     * @Param: null
     */
    int updateOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 删除一条组织信息
     * create time: 2018/10/31 20:22
     *
     * @return
     * @Param: null
     */
    int deleteOrganization(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/6 23:05
     * @Param: null
     * @return
     */
    List<Organization> getRecentlyModified();
}
