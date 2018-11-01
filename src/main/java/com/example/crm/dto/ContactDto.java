package com.example.crm.dto;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 15:43
 * @ Description：重新封装联系人列表属性
 * @ Modified By：
 */
public class ContactDto {
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
