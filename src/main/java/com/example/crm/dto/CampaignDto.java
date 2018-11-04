package com.example.crm.dto;


/**
 * Author: Bin Liu
 * Description: 重新封装活动列表属性
 * Date: 2018/11/01 15:42
 * Modified By：
 */
public class CampaignDto {
    private String type;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setValue(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
