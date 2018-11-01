package com.example.crm.dto;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 16:00
 * @ Description：重新封装产品列表属性
 * @ Modified By：
 */
public class ProductDto {
    private String value;
    private Integer id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
