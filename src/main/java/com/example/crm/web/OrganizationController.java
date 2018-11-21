package com.example.crm.web;

import com.example.crm.dao.CommentDao;
import com.example.crm.dto.OrganizationDto;
import com.example.crm.entity.*;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.*;
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
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ProductService productService;

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

    @GetMapping("/organization/getOrganizationById")
    private HashMap<String, Object> getOrganizationById(HttpServletRequest request) {
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

    @GetMapping("/organization/getOrganization")
    private HashMap<String, Object> getOrganization(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Organization organization1=new Organization();
            String organizationName=HttpServletRequestUtil.getString(request, "organizationName");
            organization1.setOrganizationName(organizationName);
            String billingCity=HttpServletRequestUtil.getString(request, "billingCity");
            organization1.setBillingCity(billingCity);
            String website=HttpServletRequestUtil.getString(request, "website");
            organization1.setWebsite(website);
            String primaryPhone=HttpServletRequestUtil.getString(request, "primaryPhone");
            organization1.setPrimaryPhone(primaryPhone);
            String assignTo=HttpServletRequestUtil.getString(request, "assignTo");
            organization1.setAssignTo(assignTo);
            Organization organization = organizationService.getOrganization(organization1);
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

    @GetMapping("organization/getUpdateInfo")
    private HashMap<String, Object> getUpdateInfo(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization = organizationService.getUpdateInfo(organizationId);
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

    @GetMapping("organization/getComment")
    private HashMap<String, Object> getComment(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization=organizationService.getOrganizationById(organizationId);
            Comment comment=commentDao.getCommentById(organization.getComment().getCommentId());
            resultMap.put("comment", comment);
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

    @GetMapping("organization/getContactByOrganizationId")
    private HashMap<String, Object> getContactByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Contact contact= contactService.getContactByOrganizationId(organizationId);
            resultMap.put("contact", contact);
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

    @GetMapping("organization/getOpportunityByOrganizationId")
    private HashMap<String, Object> getOpportunityByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Contact contact= contactService.getContactByOrganizationId(organizationId);
            Opportunity opportunity=opportunityService.getOpportunityByContactId(contact.getContactId());
            resultMap.put("opportunity", opportunity);
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

    @GetMapping("/organization/getDocumentByOrganizationId")
    private HashMap<String, Object> getgetDocumentByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization=organizationService.getOrganizationById(organizationId);
            Document document=documentService.getDocumentById(organization.getDocument().getDocumentId());
            resultMap.put("document", document);
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

    @GetMapping("product/getTicketByOrganizationId")
    private HashMap<String, Object> getTicketByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Ticket ticket = ticketService.getTicketByOrganizationId(organizationId);
            resultMap.put("ticket", ticket);
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

    @GetMapping("product/getProductByOrganizationId")
    private HashMap<String, Object> getProductByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization=organizationService.getOrganizationById(organizationId);
            Product product=organization.getProduct();
            resultMap.put("product", product);
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

    @GetMapping("product/getCampaignByOrganizationId")
    private HashMap<String, Object> getCampaignByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int organizationId = HttpServletRequestUtil.getInt(request, "organizationId");
            Organization organization=organizationService.getOrganizationById(organizationId);
            Product product=organization.getProduct();
            Campaign campaign=campaignService.getCampaignByProductId(product.getProductId());
            resultMap.put("campaign", campaign);
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
