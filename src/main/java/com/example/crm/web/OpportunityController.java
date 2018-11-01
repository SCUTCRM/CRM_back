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
    @GetMapping("/opportunitys")
    private HashMap<String,Object> listLeads(){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            List<Opportunity> opportunityList = opportunityService.getOpportunityList();
            //前端只能识别字段为value的值
            List<OpportunityDto> opportunitys = new ArrayList<>();
            for(Opportunity o : opportunityList) {
                OpportunityDto oto = new OpportunityDto();
                oto.setValue(o.getOpportName());
                oto.setId(o.getOpportId());
                opportunitys.add(oto);
            }
            resultMap.put("opportunitys",opportunitys);
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

    @PostMapping("/opportunitys/update")
    private HashMap<String,Object> updateOpportunity(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前端传过来的机会json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String opportunityStr = HttpServletRequestUtil.getString(request,"opportunity");
        Opportunity opportunity = null;
        try {
            opportunity = mapper.readValue( opportunityStr,Opportunity.class);
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新机会信息
        try {
            int result =  opportunityService.updateOpportunity( opportunity);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg", "机会更新成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg", "机会更新失败");
            }
        } catch ( OpportunityException e) {
            resultMap.put("success",false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }
}
