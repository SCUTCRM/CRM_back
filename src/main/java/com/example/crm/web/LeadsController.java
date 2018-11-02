package com.example.crm.web;

import com.example.crm.dto.LeadsDto;
import com.example.crm.entity.Leads;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.LeadsException;
import com.example.crm.service.LeadsService;
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
 * @ Date       ：2018/11/1 16:27
 * @ Description：线索操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class LeadsController {
    @Autowired
    private LeadsService leadsService;

    //获取联系人信息
    @GetMapping("/leads/leads")
    private HashMap<String, Object> listLeads() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Leads> leadsList = leadsService.getLeadsList();
            //前端只能识别字段为value的值
            List<LeadsDto> leads = new ArrayList<>();
            for (Leads l : leadsList) {
                LeadsDto lto = new LeadsDto();
                lto.setValue(l.getFirstName());
                lto.setId(l.getLeadId());
                leads.add(lto);
            }
            resultMap.put("leads", leads);
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

    @GetMapping("/leads/getLeads")
    private HashMap<String, Object> getLeads(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int leadsId = HttpServletRequestUtil.getInt(request, "leadsId");
            Leads leads = leadsService.getLeads(leadsId);
            resultMap.put("leads", leads);
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
    private HashMap<String, Object> insertLeads(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取leads对应的json字符串
        String leadsStr = HttpServletRequestUtil.getString(request, "leads");
        ObjectMapper mapper = new ObjectMapper();
        Leads leads = null;
        try {
            leads = mapper.readValue(leadsStr, Leads.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = leadsService.insertLeads(leads);
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

    @PostMapping("/leads/update")
    private HashMap<String, Object> updateContact(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的线索json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String leadsStr = HttpServletRequestUtil.getString(request, "contact");
        Leads leads = null;
        try {
            leads = mapper.readValue(leadsStr, Leads.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新线索信息
        try {
            int result = leadsService.updateLeads(leads);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "线索更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "线索更新失败");
            }
        } catch (LeadsException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/leads/delete")
    private HashMap<String, Object> deleteContact(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int leadsId = HttpServletRequestUtil.getInt(request, "leadsId");
        try {
            int result = leadsService.deleteLeads(leadsId);
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
}
