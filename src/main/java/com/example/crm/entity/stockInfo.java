package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：库存实体类
 * @ Modified By：
 */
public class stockInfo {
    private Integer stockInfoId;
    //库存的使用单位
    private Integer usageUnit;
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

    public Integer getUsageUnit() {
        return usageUnit;
    }

    public void setUsageUnit(Integer usageUnit) {
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
