package com.example.crm.web;

import com.example.crm.dto.OrganizationDto;
import com.example.crm.entity.Organization;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.OrganizationService;
import com.example.crm.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 21:03
 * @ Description：组织操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    //获取组织信息
    @GetMapping("/organization/organizations")
    private HashMap<String, Object> listOrganization() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Organization> organizationList = organizationService.getOrganizationList();
            //前端只能识别字段为value的值
            List<OrganizationDto> organizations = new ArrayList<>();
            for (Organization o : organizationList) {
                OrganizationDto oto = new OrganizationDto();
                oto.setValue(o.getOrganizationName());
                oto.setId(o.getOrganizationId());
                organizations.add(oto);
            }
            resultMap.put("organizations", organizations);
            resultMap.put("success", true);
            resultMap.put("code", 200);
            resultMap.put("msg", "数据获取成功");
        } catch (Exception ex) {
            resultMap.put("success", false);
            resultMap.put("code", -200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }

    @GetMapping("/organization/getOrganization")
    private HashMap<String, Object> getOrganization(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization = organizationService.getOrganizationById(organizationId);
            resultMap.put("organization", organization);
            resultMap.put("success", true);
            resultMap.put("code", 200);
            resultMap.put("msg", "数据获取成功");
        } catch (Exception ex) {
            resultMap.put("success", false);
            resultMap.put("code", -200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }

    @PostMapping("/organization/insert")
    private HashMap<String, Object> insertOrganization(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取organization对应的json字符串
        String organizationStr = HttpServletRequestUtil.getString(request, "organization");
        ObjectMapper mapper = new ObjectMapper();
        Organization organization = null;
        try {
            organization = mapper.readValue(organizationStr, Organization.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = organizationService.insertOrganization(organization);
            if (result == 1) {
                resultMap.put("success", false);
                resultMap.put("msg", "保存成功");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "保存失败");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/organizations/update")
    private HashMap<String, Object> updateOrganization(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的组织json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String organizationStr = HttpServletRequestUtil.getString(request, "organization");
        Organization organization = null;
        try {
            organization = mapper.readValue(organizationStr, Organization.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新组织信息
        try {
            int result = organizationService.updateOrganization(organization);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "组织更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "组织更新失败");
            }
        } catch (ProductException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/organization/delete")
    private HashMap<String, Object> deleteOpportunity(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
        try {
            int result = organizationService.deleteOrganization(organizationId);
            if (result == 1) {
                resultMap.put("success", false);
                resultMap.put("msg", "删除成功");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "删除失败");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    //获取组织信息
    @GetMapping("/organization/recentlyModified")
    private HashMap<String, Object> getRecentlyModified() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Organization> organizationList = organizationService.getRecentlyModified();
            //前端只能识别字段为value的值
            List<OrganizationDto> organizations = new ArrayList<>();
            for (Organization o : organizationList) {
                OrganizationDto oto = new OrganizationDto();
                oto.setValue(o.getOrganizationName());
                oto.setId(o.getOrganizationId());
                organizations.add(oto);
            }
            resultMap.put("organizations", organizations);
            resultMap.put("success", true);
            resultMap.put("code", 200);
            resultMap.put("msg", "数据获取成功");
        } catch (Exception ex) {
            resultMap.put("success", false);
            resultMap.put("code", -200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }
}
