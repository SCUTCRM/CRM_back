package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：活动实体类
 * @ Modified By：
 */
public class Campaign {
    private Integer campaignId;
    //活动名字
    private String campaignName;
    //活动类型
    private String campaignType;
    //活动状态 0表示 1表示
    private Integer campaignStatus;
    //预期收入
    private Double expectedRevenue;
    //预期结束时间
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    private String updateInfo;
    //产品
    private Product product;
    //预期和实际
    private ExpActual expActual;
    //机会
    private Opportunity opportunity;

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
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

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ExpActual getExpActual() {
        return expActual;
    }

    public void setExpActual(ExpActual expActual) {
        this.expActual = expActual;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
