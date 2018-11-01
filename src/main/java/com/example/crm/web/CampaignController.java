package com.example.crm.web;

import com.example.crm.dto.CampaignDto;
import com.example.crm.entity.Campaign;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.CampaignException;
import com.example.crm.service.CampaignService;
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
 * @ Date       ：2018/11/1 15:27
 * @ Description：活动操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    //获取活动信息
    @GetMapping("/campaigns")
    private HashMap<String,Object> listCampaign(){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            List<Campaign> campaignList = campaignService.getCampaignList();
            //前端只能识别字段为value的值
            List<CampaignDto> campaigns = new ArrayList<>();
            for(Campaign c : campaignList) {
                CampaignDto dto = new CampaignDto();
                dto.setValue(c.getCampaignType());
                dto.setId(c.getCampaignId());
                campaigns.add(dto);
            }
            resultMap.put("campaigns",campaigns);
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

    @PostMapping("/campaigns/update")
    private HashMap<String,Object> updateCampaign(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前端传过来的活动json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String campaignStr = HttpServletRequestUtil.getString(request,"campaign");
        Campaign campaign = null;
        try {
            campaign = mapper.readValue(campaignStr,Campaign.class);
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新活动信息
        try {
            int result = campaignService.updateCampaign(campaign);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg", "活动更新成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg", "活动更新失败");
            }
        } catch (CampaignException e) {
            resultMap.put("success",false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }


}
