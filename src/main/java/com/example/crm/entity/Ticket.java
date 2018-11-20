package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：售后客服实体类
 * @ Modified By：
 */
public class Ticket {
    private Integer ticketId;
    //标题
    private String title;
    //状态
    private Integer status;
    //优先级 从0-10优先级依次递减
    private Integer priority;
    //分配给
    private Integer assignTo;
    //小时数
    private String hourNum;
    //种类
    private String category;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm aaa")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm aaa")
    private Date modifiedTime;
    //问题严重性
    private Integer severity;
    //时长天数
    private Integer days;
    //描述
    private String description;
    //更改
    private String updateInfo;
    //组织
    private Organization organization;
    //产品
    private Product product;
    //文件
    private Document document;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Integer assignTo) {
        this.assignTo = assignTo;
    }

    public String getHourNum() {
        return hourNum;
    }

    public void setHourNum(String hourNum) {
        this.hourNum = hourNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
