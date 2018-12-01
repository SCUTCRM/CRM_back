package com.example.crm.entity;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/12/1 16:25
 * @ Description：活动实体类
 * @ Modified By：
 */
public class Activity {
    //活动Id
    private Integer activityId;
    //活动状态
    private String status;
    //活动类型
    private String activityType;
    //主题
    private String subject;
    //相关
    private String relatedTo;
    //开始时间
    private Date startDateandTime;
    //循环
    private String recurrence;
    //分配给
    private String assignTo;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public Date getStartDateandTime() {
        return startDateandTime;
    }

    public void setStartDateandTime(Date startDateandTime) {
        this.startDateandTime = startDateandTime;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }
}
