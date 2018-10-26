package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：用户实体类
 * @ Modified By：
 */
public class User {
    private Integer userId;
    //用户姓名
    private String userName;
    //账号密码
    private String passWord;
    //手机号码
    private String phone;
    //电子邮箱
    private String email;
    //用户称呼（头衔）
    private String title;
    //用户地址
    private address address;
    //线索
    private leads leads;
    //联系人
    private contact contact;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public com.example.crm.entity.address getAddress() {
        return address;
    }

    public void setAddress(com.example.crm.entity.address address) {
        this.address = address;
    }

    public com.example.crm.entity.leads getLeads() {
        return leads;
    }

    public void setLeads(com.example.crm.entity.leads leads) {
        this.leads = leads;
    }

    public com.example.crm.entity.contact getContact() {
        return contact;
    }

    public void setContact(com.example.crm.entity.contact contact) {
        this.contact = contact;
    }
}
