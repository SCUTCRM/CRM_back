package com.example.crm.service;

import com.example.crm.entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 10:12
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationServiceImplTest {
    @Autowired
    private OrganizationService organizationService;

    @Test
    public void getOrganizationList() {
        List<Organization> list = organizationService.getOrganizationList();
        System.out.println(list.get(0));
    }
}