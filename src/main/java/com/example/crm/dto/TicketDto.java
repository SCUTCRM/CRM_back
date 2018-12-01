package com.example.crm.dto;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 15:44
 * @ Description：重新封装售后服务列表属性
 * @ Modified By：
 */
public class TicketDto {
    private String title;
    private String organizationName;
    private String status;
    private Integer priority;
    private String assignTo;
    private String contactName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
