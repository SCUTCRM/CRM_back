package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/15 14:57
 * @ Description：文件实体类
 * @ Modified By：
 */
public class Document {
    //文件id
    private Integer documentId;
    //标题
    private String title;
    //文件名
    private String fileName;
    //文件序号
    private Integer documentNo;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm aaa")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm aaa")
    private Date modifiedTime;
    //分配给
    private Integer assignTo;
    //更新
    private String updateInfo;
    //描述
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Integer assignTo) {
        this.assignTo = assignTo;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(Integer documentNo) {
        this.documentNo = documentNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
