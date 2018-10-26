package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：机会实体类
 * @ Modified By：
 */
public class opportunity {
    private Integer opportId;
    //机会名字
    private String opportName;
    //概率
    private Double prob;
    //预测金额
    private Double forcastAmount;
    //是否是来自于线索 T和F
    private String isFromLead;
    //分配给
    private Integer assignTo;
    //线索来源
    private String leadSource;
    //更改
    private String update;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    //类型
    private Integer type;
    //期望结束时间
    private Date expCloseTime;
    //描述
    private String description;
    //联系人
    private contact contact;

    public Integer getOpportId() {
        return opportId;
    }

    public void setOpportId(Integer opportId) {
        this.opportId = opportId;
    }

    public String getOpportName() {
        return opportName;
    }

    public void setOpportName(String opportName) {
        this.opportName = opportName;
    }

    public Double getProb() {
        return prob;
    }

    public void setProb(Double prob) {
        this.prob = prob;
    }

    public Double getForcastAmount() {
        return forcastAmount;
    }

    public void setForcastAmount(Double forcastAmount) {
        this.forcastAmount = forcastAmount;
    }

    public String getIsFromLead() {
        return isFromLead;
    }

    public void setIsFromLead(String isFromLead) {
        this.isFromLead = isFromLead;
    }

    public Integer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Integer assignTo) {
        this.assignTo = assignTo;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getExpCloseTime() {
        return expCloseTime;
    }

    public void setExpCloseTime(Date expCloseTime) {
        this.expCloseTime = expCloseTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.crm.entity.contact getContact() {
        return contact;
    }

    public void setContact(com.example.crm.entity.contact contact) {
        this.contact = contact;
    }
}
