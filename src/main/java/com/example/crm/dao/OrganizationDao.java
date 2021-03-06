package com.example.crm.dao;

import com.example.crm.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * description: 获取所有的组织信息
     * create time: 2018/11/1 9:52
     *
     * @return
     * @Param: null
     */
    List<Organization> getOrganizationList();

    /**
     * create by: Bin Liu
     * description: 根据id获取指定组织
     * create time: 2018/10/31 19:58
     *
     * @return
     * @Param: null
     */
    Organization getOrganizationById(Integer organizationId);

    /**
     * create by: Bin Liu
     * description: 根据organizationName获取指定组织
     * create time: 2018/11/13 23:31
     * @Param: null
     * @return
     */
    Organization getOrganizationByName(String organizationName);
    /**
     * create by: Bin Liu
     * description: 增加一个组织
     * create time: 2018/10/31 20:01
     *
     * @return
     * @Param: null
     */
    int insertOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 更新一个组织
     * create time: 2018/10/31 20:02
     *
     * @return
     * @Param: null
     */
    int updateOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 删除一个组织
     * create time: 2018/10/31 20:02
     *
     * @return
     * @Param: null
     */
    int deleteOrganization(Integer OrganizationId);

    /**
     * create by: Bin Liu
     * description: 获取最近更新信息
     * create time: 2018/11/6 22:48
     * @Param: null
     * @return
     */
    List<Organization> getRecentlyModified();
    
    /**
     * create by: Bin Liu
     * description: 动态获取
     * create time: 2018/11/8 23:23
     * @Param: null
     * @return 
     */
    List<Organization> getOrganization(Organization organization);

    /**
     * create by: Bin Liu
     * description: 获取更新信息
     * create time: 2018/11/12 23:13
     * @Param: null
     * @return
     */
    Organization getUpdateInfo(Integer organizationId);
    
    /**
     * create by: Bin Liu
     * description: 根据productId获取组织信息
     * create time: 2018/11/14 21:01
     * @Param: null
     * @return 
     */
    Organization getOrganizationByProductId(Integer productId);

    /**
     * create by: Bin Liu
     * description: 增加评论
     * create time: 2018/11/19 17:00
     * @Param: null
     * @return
     */
    int addComment(Integer organizationId);
}
