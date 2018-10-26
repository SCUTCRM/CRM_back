package com.example.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：产品实体类
 * @ Modified By：
 */
public class product {
    private Integer productId;
    //产品名称
    private String productName;
    //零件号
    private Integer partNumber;
    //销售开始日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleStartDate;
    //产品是否在售 T和F
    private String active;
    //销售结束日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleEndDate;
    //产品编号
    private Integer productNumber;
    //网站
    private String website;
    //供应商的名字
    private String ventorName;
    //供应商Id
    private Integer ventorPartno;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    //生产厂家
    private String manufacturer;
    //描述
    private String description;
    //更改
    private String update;
    //价格
    private price price;
    //库存
    private stockInfo stockInfo;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Integer partNumber) {
        this.partNumber = partNumber;
    }

    public Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Date saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVentorName() {
        return ventorName;
    }

    public void setVentorName(String ventorName) {
        this.ventorName = ventorName;
    }

    public Integer getVentorPartno() {
        return ventorPartno;
    }

    public void setVentorPartno(Integer ventorPartno) {
        this.ventorPartno = ventorPartno;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public com.example.crm.entity.price getPrice() {
        return price;
    }

    public void setPrice(com.example.crm.entity.price price) {
        this.price = price;
    }

    public com.example.crm.entity.stockInfo getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(com.example.crm.entity.stockInfo stockInfo) {
        this.stockInfo = stockInfo;
    }
}
