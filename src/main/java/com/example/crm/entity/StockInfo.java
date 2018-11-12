package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：库存实体类
 * @ Modified By：
 */
public class StockInfo {
    private Integer stockInfoId;
    //库存的使用单位
    private String usageUnit;
    //库存数量
    private Integer qtyInStock;
    //数量/单价
    private Integer unit;
    //需求量
    private Integer qtyInDemand;

    public Integer getStockInfoId() {
        return stockInfoId;
    }

    public void setStockInfoId(Integer stockInfoId) {
        this.stockInfoId = stockInfoId;
    }

    public String getUsageUnit() {
        return usageUnit;
    }

    public void setUsageUnit(String usageUnit) {
        this.usageUnit = usageUnit;
    }

    public Integer getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Integer qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getQtyInDemand() {
        return qtyInDemand;
    }

    public void setQtyInDemand(Integer qtyInDemand) {
        this.qtyInDemand = qtyInDemand;
    }
}
