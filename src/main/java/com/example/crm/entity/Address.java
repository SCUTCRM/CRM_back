package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：地址实体类
 * @ Modified By：
 */

public class Address {
    private Integer addressId;
    //邮寄街道
    private String mailStreet;
    //邮寄邮箱
    private String mailPoBox;
    //邮寄城市
    private String mailCity;
    //邮寄乡村
    private String mailCountry;
    //邮寄的州
    private String mailState;
    //其他街道
    private String otherStreet;
    //其他邮箱
    private String otherPoBox;
    //其他城市
    private String otherCity;
    //其他乡村
    private String otherCountry;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getMailStreet() {
        return mailStreet;
    }

    public void setMailStreet(String mailStreet) {
        this.mailStreet = mailStreet;
    }

    public String getMailPoBox() {
        return mailPoBox;
    }

    public void setMailPoBox(String mailPoBox) {
        this.mailPoBox = mailPoBox;
    }

    public String getMailCity() {
        return mailCity;
    }

    public void setMailCity(String mailCity) {
        this.mailCity = mailCity;
    }

    public String getMailCountry() {
        return mailCountry;
    }

    public void setMailCountry(String mailCountry) {
        this.mailCountry = mailCountry;
    }

    public String getMailState() {
        return mailState;
    }

    public void setMailState(String mailState) {
        this.mailState = mailState;
    }

    public String getOtherStreet() {
        return otherStreet;
    }

    public void setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
    }

    public String getOtherPoBox() {
        return otherPoBox;
    }

    public void setOtherPoBox(String otherPoBox) {
        this.otherPoBox = otherPoBox;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }

    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }
}
