package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：价格实体
 * @ Modified By：
 */
public class price {
    private Integer priceId;
    //单价
    private Double unitPrice;
    //佣金率
    private Double commissionRate;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
