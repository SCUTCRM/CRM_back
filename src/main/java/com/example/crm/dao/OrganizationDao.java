package com.example.crm.dao;

import com.example.crm.entity.Organization;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 19:52
 * @ Description：组织数据库访问层接口
 * @ Modified By：
 */
@Component
public interface OrganizationDao {
    /**
     * create by: Bin Liu
     * description: 根据id获取指定组织
     * create time: 2018/10/31 19:58
     * @Param: null
     * @return 
     */
    Organization getOrganization(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 增加一个组织
     * create time: 2018/10/31 20:01
     * @Param: null
     * @return 
     */
    int insertOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 更新一个组织
     * create time: 2018/10/31 20:02
     * @Param: null
     * @return
     */
    int updateOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 删除一个组织
     * create time: 2018/10/31 20:02
     * @Param: null
     * @return
     */
    int deleteOrganization(Integer OrganizationId);
}
