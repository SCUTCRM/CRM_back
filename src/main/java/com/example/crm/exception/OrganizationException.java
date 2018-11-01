package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:33
 * @ Description：${description}
 * @ Modified By：
 */
public class OrganizationException extends RuntimeException{
    private Integer code;

    public OrganizationException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
