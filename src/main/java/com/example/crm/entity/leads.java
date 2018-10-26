package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：线索实体类
 * @ Modified By：
 */
public class leads {
    private Integer leadId;
    //名字
    private String firstName;
    //姓
    private String lastName;
    //常用电话
    private Integer primaryPhone;
    //网站
    private String webSite;
    //常用邮箱
    private String primaryEmail;
    //分配给
    private Integer assignedTo;
    //年收入
    private Double annualRevenue;
    //电话
    private Integer phone;
    //邮件
    private String email;
    //更新
    private String update;
    //描述
    private String description;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    //组织
    private organization organization;
    //产品
    private product product;
    //地址
    private address address;

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(Integer primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(Double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public com.example.crm.entity.organization getOrganization() {
        return organization;
    }

    public void setOrganization(com.example.crm.entity.organization organization) {
        this.organization = organization;
    }

    public com.example.crm.entity.product getProduct() {
        return product;
    }

    public void setProduct(com.example.crm.entity.product product) {
        this.product = product;
    }

    public com.example.crm.entity.address getAddress() {
        return address;
    }

    public void setAddress(com.example.crm.entity.address address) {
        this.address = address;
    }
}
