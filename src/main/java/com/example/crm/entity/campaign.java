package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：活动实体类
 * @ Modified By：
 */
public class campaign {
    private Integer campaignId;
    //活动类型
    private Integer campaignType;
    //活动状态 0表示 1表示
    private Integer campaignStatus;
    //预期收入
    private Double expectedRevenue;
    //预期结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedCloseDate;
    //分配给
    private Integer assignTo;
    //目标大小
    private Integer targetSize;
    //发送数量
    private Integer numSent;
    //目标听众
    private String targetAudience;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    //赞助
    private Integer sponsor;
    //描述
    private String description;
    //更新
    private String update;
    //产品
    private product product;
    //预期和实际
    private expActual expActual;
    //机会
    private opportunity opportunity;

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(Integer campaignType) {
        this.campaignType = campaignType;
    }

    public Integer getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(Integer campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public Double getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(Double expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Date getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public Integer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Integer assignTo) {
        this.assignTo = assignTo;
    }

    public Integer getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(Integer targetSize) {
        this.targetSize = targetSize;
    }

    public Integer getNumSent() {
        return numSent;
    }

    public void setNumSent(Integer numSent) {
        this.numSent = numSent;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getSponsor() {
        return sponsor;
    }

    public void setSponsor(Integer sponsor) {
        this.sponsor = sponsor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public com.example.crm.entity.product getProduct() {
        return product;
    }

    public void setProduct(com.example.crm.entity.product product) {
        this.product = product;
    }

    public com.example.crm.entity.expActual getExpActual() {
        return expActual;
    }

    public void setExpActual(com.example.crm.entity.expActual expActual) {
        this.expActual = expActual;
    }

    public com.example.crm.entity.opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(com.example.crm.entity.opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
