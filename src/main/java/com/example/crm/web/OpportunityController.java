package com.example.crm.web;

import com.example.crm.dto.OpportunityDto;
import com.example.crm.entity.Opportunity;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.OpportunityException;
import com.example.crm.service.OpportunityService;
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
 * @ Date       ：2018/11/1 16:45
 * @ Description：机会操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class OpportunityController {
    @Autowired
    private OpportunityService opportunityService;

    //获取机会信息
    @GetMapping("/opportunity/opportunitys")
    private HashMap<String, Object> listLeads() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Opportunity> opportunityList = opportunityService.getOpportunityList();
            //前端只能识别字段为value的值
            List<OpportunityDto> opportunitys = new ArrayList<>();
            for (Opportunity o : opportunityList) {
                OpportunityDto oto = new OpportunityDto();
                oto.setOpportunityName(o.getOpportName());
                oto.setOrganizationName(o.getContact().getOrganization().getOrganizationName());
                oto.setSalesStage(o.getSalesStage());
                oto.setLeadSource(o.getLeadSource());
                oto.setExpectedCloseDate(o.getExpectedCloseDate());
                oto.setAmount(o.getForcastAmount());
                oto.setAssignTo(o.getAssignTo());
                oto.setContactName(o.getContact().getFirstName());
                opportunitys.add(oto);
            }
            resultMap.put("opportunitys", opportunitys);
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

    @GetMapping("/opportunity/getOpportunityById")
    private HashMap<String, Object> getOpportunityById(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int opportunityId = HttpServletRequestUtil.getInt(request, "opportunityId");
            Opportunity opportunity = opportunityService.getOpportunityById(opportunityId);
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

    @PostMapping("/opportunity/insert")
    private HashMap<String, Object> insertOpportunity(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取opportunity对应的json字符串
        String opportunityStr = HttpServletRequestUtil.getString(request, "opportunity");
        ObjectMapper mapper = new ObjectMapper();
        Opportunity opportunity = null;
        try {
            opportunity = mapper.readValue(opportunityStr, Opportunity.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = opportunityService.insertOpportunity(opportunity);
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

    @PostMapping("/opportunity/update")
    private HashMap<String, Object> updateOpportunity(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的机会json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String opportunityStr = HttpServletRequestUtil.getString(request, "opportunity");
        Opportunity opportunity = null;
        try {
            opportunity = mapper.readValue(opportunityStr, Opportunity.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新机会信息
        try {
            int result = opportunityService.updateOpportunity(opportunity);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "机会更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "机会更新失败");
            }
        } catch (OpportunityException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/opportunity/delete")
    private HashMap<String, Object> deleteOpportunity(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int opportunityId = HttpServletRequestUtil.getInt(request, "opportunityId");
        try {
            int result = opportunityService.deleteOpportunity(opportunityId);
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

    //获取机会信息
    @GetMapping("/opportunity/recentlyModified")
    private HashMap<String, Object> getRecentlyModified() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Opportunity> opportunities = opportunityService.getRecentlyModified();
            resultMap.put("opportunities", opportunities);
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
