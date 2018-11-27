package com.example.crm.web;

import com.example.crm.dao.CommentDao;
import com.example.crm.dto.ContactDto;
import com.example.crm.entity.*;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ContactException;
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
 * @ Date       ：2018/11/1 16:06
 * @ Description：联系人操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private CommentDao commentDao;

    //获取联系人信息
    @GetMapping("contact/contacts")
    private HashMap<String, Object> listCampaign() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Contact> contactList = contactService.getContactList();
            //前端只能识别字段为value的值
            List<ContactDto> contacts = new ArrayList<>();
            for (Contact c : contactList) {
                ContactDto cto = new ContactDto();
                cto.setValue(c.getFirstName());
                cto.setId(c.getContactId());
                contacts.add(cto);
            }
            resultMap.put("contacts", contacts);
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

    @GetMapping("/contact/getContactById")
    private HashMap<String, Object> getCampaignById(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact = contactService.getContactById(contactId);
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

    @GetMapping("/contact/getContact")
    private HashMap<String, Object> getCampaign(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Contact contact = new Contact();
            String firstName = HttpServletRequestUtil.getString(request, "firstName");
            contact.setFirstName(firstName);
            String lastName = HttpServletRequestUtil.getString(request, "lastName");
            contact.setLastName(lastName);
            String title = HttpServletRequestUtil.getString(request, "title");
            contact.setTitle(title);
            String organizationName = HttpServletRequestUtil.getString(request, "organizationName");
            Organization organization = organizationService.getOrganizationByName(organizationName);
            contact.setOrganization(organization);
            String primaryEmail = HttpServletRequestUtil.getString(request, "primaryEmail");
            contact.setPrimaryEmail(primaryEmail);
            String officePhone = HttpServletRequestUtil.getString(request, "officePhone");
            contact.setOfficePhone(officePhone);
            String assignTo = HttpServletRequestUtil.getString(request, "assignTo");
            contact.setAssignTo(assignTo);
            List<Contact> contacts=contactService.getContact(contact);
            resultMap.put("contacts", contacts);
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

    @PostMapping("/contact/insert")
    private HashMap<String, Object> insertContact(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取contact对应的json字符串
        String contactStr = HttpServletRequestUtil.getString(request, "contact");
        ObjectMapper mapper = new ObjectMapper();
        Contact contact = null;
        try {
            contact = mapper.readValue(contactStr, Contact.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = contactService.insertContact(contact);
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


    @PostMapping("/contacts/update")
    private HashMap<String, Object> updateContact(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的联系人json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String contactStr = HttpServletRequestUtil.getString(request, "contact");
        Contact contact = null;
        try {
            contact = mapper.readValue(contactStr, Contact.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新联系人信息
        try {
            int result = contactService.updateContact(contact);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "联系人更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "联系人更新失败");
            }
        } catch (ContactException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/contact/delete")
    private HashMap<String, Object> deleteContact(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int contactId = HttpServletRequestUtil.getInt(request, "contactId");
        try {
            int result = contactService.deleteContact(contactId);
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

    //获取联系人信息
    @GetMapping("contact/recentlyModified")
    private HashMap<String, Object> getRecentlyModified() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Contact> contactList = contactService.getRecentlyModified();
            //前端只能识别字段为value的值
            List<ContactDto> contacts = new ArrayList<>();
            for (Contact c : contactList) {
                ContactDto cto = new ContactDto();
                cto.setValue(c.getFirstName());
                cto.setId(c.getContactId());
                contacts.add(cto);
            }
            resultMap.put("contacts", contacts);
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

    @GetMapping("contact/getUpdateInfo")
    private HashMap<String, Object> getUpdateInfo(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact = contactService.getUpdateInfo(contactId);
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

    @GetMapping("contact/getComment")
    private HashMap<String, Object> getComment(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact=contactService.getContactById(contactId);
            Comment comment=commentDao.getCommentById(contact.getComment().getCommentId());
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

    @GetMapping("contact/getOpportunityByContactId")
    private HashMap<String, Object> getOpportunityByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact= contactService.getContactById(contactId);
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

    @GetMapping("contact/getTicketByContactId")
    private HashMap<String, Object> getTicketByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact=contactService.getContactById(contactId);
            Organization organization=contact.getOrganization();
            Ticket ticket = ticketService.getTicketByOrganizationId(organization.getOrganizationId());
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

    @GetMapping("contact/getProductByContactId")
    private HashMap<String, Object> getProductByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact=contactService.getContactById(contactId);
            Organization organization=contact.getOrganization();
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

    @GetMapping("/contact/getDocumentByContactId")
    private HashMap<String, Object> getgetDocumentByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact=contactService.getContactById(contactId);
            Document document=documentService.getDocumentById(contact.getDocument().getDocumentId());
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

    @GetMapping("contact/getCampaignByContactId")
    private HashMap<String, Object> getCampaignByOrganizationId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int contactId = HttpServletRequestUtil.getInt(request, "contactId");
            Contact contact=contactService.getContactById(contactId);
            Organization organization=contact.getOrganization();
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
