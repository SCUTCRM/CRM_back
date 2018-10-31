package com.example.crm.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 11:07
 * @ Description：预期和实际实体类
 * @ Modified By：
 */
public class ExpActual {
    private Integer sxpActualId;
    //预算成本
    private Double budgetCost;
    //实际成本
    private Double actualCost;
    //预期的回应
    private String expResponse;
    //实际的回应
    private String actualResponse;
    //预期的数量
    private Integer expSaleCount;
    //实际的数量
    private Integer actualSaleCount;
    //期望的roi(投资回报率)
    private Double expRoi;
    //实际的roi
    private Double actualRoi;

    public Integer getSxpActualId() {
        return sxpActualId;
    }

    public void setSxpActualId(Integer sxpActualId) {
        this.sxpActualId = sxpActualId;
    }

    public Double getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(Double budgetCost) {
        this.budgetCost = budgetCost;
    }

    public Double getActualCost() {
        return actualCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

    public String getExpResponse() {
        return expResponse;
    }

    public void setExpResponse(String expResponse) {
        this.expResponse = expResponse;
    }

    public String getActualResponse() {
        return actualResponse;
    }

    public void setActualResponse(String actualResponse) {
        this.actualResponse = actualResponse;
    }

    public Integer getExpSaleCount() {
        return expSaleCount;
    }

    public void setExpSaleCount(Integer expSaleCount) {
        this.expSaleCount = expSaleCount;
    }

    public Integer getActualSaleCount() {
        return actualSaleCount;
    }

    public void setActualSaleCount(Integer actualSaleCount) {
        this.actualSaleCount = actualSaleCount;
    }

    public Double getExpRoi() {
        return expRoi;
    }

    public void setExpRoi(Double expRoi) {
        this.expRoi = expRoi;
    }

    public Double getActualRoi() {
        return actualRoi;
    }

    public void setActualRoi(Double actualRoi) {
        this.actualRoi = actualRoi;
    }
}
