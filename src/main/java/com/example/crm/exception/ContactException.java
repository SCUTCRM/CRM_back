package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:39
 * @ Description：联系人操作异常类
 * @ Modified By：
 */
public class ContactException extends RuntimeException{
    private Integer code;

    public ContactException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
