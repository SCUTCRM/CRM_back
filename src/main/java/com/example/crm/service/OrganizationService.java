package com.example.crm.service;

import com.example.crm.entity.Organization;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:14
 * @ Description：${description}
 * @ Modified By：
 */
public interface OrganizationService {
    /**
     * create by: Bin Liu
     * description: 获取一条组织信息
     * create time: 2018/10/31 20:21
     * @Param: null
     * @return
     */
    Organization getOrganization(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 插入一条组织信息
     * create time: 2018/10/31 20:22
     * @Param: null
     * @return
     */
    int insertOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 更新一条组织信息
     * create time: 2018/10/31 20:22
     * @Param: null
     * @return
     */
    int updateOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 删除一条组织信息
     * create time: 2018/10/31 20:22
     * @Param: null
     * @return
     */
    int deleteOrganization(Integer OrganizationId);
}
