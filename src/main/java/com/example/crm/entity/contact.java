package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：联系人实体类
 * @ Modified By：
 */
public class contact {
    private Integer contactId;
    //名字
    private String firstName;
    //姓
    private String lastName;
    //称呼（头衔）
    private String title;
    //邮件
    private String email;
    //办公室电话
    private Integer officePhone;
    //分配给
    private Integer assignedTo;
    //是否是来自于线索 T和F
    private String isFromLead;
    //家的电话
    private Integer homePhone;
    //更改
    private String update;
    //线索状态
    private Integer Leadstate;
    //行业
    private String industry;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    //生日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dayOfBirth;
    //部门
    private String departMent;
    //助理
    private String assistant;
    //助理电话
    private Integer assistantPhone;
    //个人资料图片
    private String profilePicture;
    //描述
    private String description;
    //组织
    private organization organization;
    //地址
    private address address;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(Integer officePhone) {
        this.officePhone = officePhone;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getIsFromLead() {
        return isFromLead;
    }

    public void setIsFromLead(String isFromLead) {
        this.isFromLead = isFromLead;
    }

    public Integer getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Integer homePhone) {
        this.homePhone = homePhone;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Integer getLeadstate() {
        return Leadstate;
    }

    public void setLeadstate(Integer leadstate) {
        Leadstate = leadstate;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public Integer getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(Integer assistantPhone) {
        this.assistantPhone = assistantPhone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.crm.entity.organization getOrganization() {
        return organization;
    }

    public void setOrganization(com.example.crm.entity.organization organization) {
        this.organization = organization;
    }

    public com.example.crm.entity.address getAddress() {
        return address;
    }

    public void setAddress(com.example.crm.entity.address address) {
        this.address = address;
    }
}
