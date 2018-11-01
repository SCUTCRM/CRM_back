package com.example.crm.web;

import com.example.crm.dto.ContactDto;
import com.example.crm.entity.Contact;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ContactException;
import com.example.crm.service.ContactService;

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

    //获取联系人信息
    @GetMapping("/contacts")
    private HashMap<String,Object> listCampaign(){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            List<Contact> contactList = contactService.getContactList();
            //前端只能识别字段为value的值
            List<ContactDto> contacts = new ArrayList<>();
            for(Contact c : contactList) {
                ContactDto cto = new ContactDto();
                cto.setValue(c.getFirstName());
                cto.setId(c.getContactId());
                contacts.add(cto);
            }
            resultMap.put("contacts",contacts);
            resultMap.put("success",true);
            resultMap.put("code",200);
            resultMap.put("msg","数据获取成功");
        }catch (Exception ex){
            resultMap.put("success",false);
            resultMap.put("code",-200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }

    @PostMapping("/contacts/update")
    private HashMap<String,Object> updateContact(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前端传过来的联系人json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String contactStr = HttpServletRequestUtil.getString(request,"contact");
        Contact contact = null;
        try {
            contact = mapper.readValue(contactStr,Contact.class);
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新联系人信息
        try {
            int result = contactService.updateContact(contact);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg", "联系人更新成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg", "联系人更新失败");
            }
        } catch (ContactException e) {
            resultMap.put("success",false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }
}
