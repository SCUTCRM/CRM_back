package com.example.crm.service.impl;

import com.example.crm.dao.OrganizationDao;
import com.example.crm.entity.Organization;
import com.example.crm.exception.OrganizationException;
import com.example.crm.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:23
 * @ Description：组织业务逻辑实现类
 * @ Modified By：
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public List<Organization> getOrganizationList() {
        return organizationDao.getOrganizationList();
    }

    @Override
    public Organization getOrganizationById(Integer organizationId) {
        return organizationDao.getOrganizationById(organizationId);
    }

    @Override
    public Organization getOrganization(Organization organization) {
        return organizationDao.getOrganization(organization);
    }

    @Transactional
    @Override
    public int insertOrganization(Organization organization) {
        if (organization == null) {
            return 0;
        }
        try {
            int result = organizationDao.insertOrganization(organization);
            return result;
        } catch (Exception e) {
            throw new OrganizationException("插入订单失败",-1);
        }
    }

    @Transactional
    @Override
    public int updateOrganization(Organization organization) {
        if (organization == null || organization.getOrganizationId() == null) {
            return 0;
        }
        try {
            int result = organizationDao.updateOrganization(organization);
            return result;
        } catch (Exception e) {
            throw  new OrganizationException("更新订单失败",-1);
        }
    }

    @Transactional
    @Override
    public int deleteOrganization(Integer organizationId) {
        if (organizationId == null) {
            return 0;
        }
        try {
            int result = organizationDao.deleteOrganization(organizationId);
            return result;
        } catch (Exception e) {
            throw  new OrganizationException("删除订单失败",-2);
        }
    }

    @Override
    public List<Organization> getRecentlyModified() {
        return organizationDao.getRecentlyModified();
    }

    @Override
    public Organization getUpdateInfo(Integer organizationId) {
        return organizationDao.getUpdateInfo(organizationId);
    }

    @Override
    public Organization getOrganizationByProductId(Integer productId) {
        return organizationDao.getOrganizationByProductId(productId);
    }

    @Override
    public Organization getOrganizationByName(String organizationName) {
        return organizationDao.getOrganizationByName(organizationName);
    }
}
