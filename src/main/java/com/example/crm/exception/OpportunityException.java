package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:40
 * @ Description：机会操作异常类
 * @ Modified By：
 */
public class OpportunityException  extends RuntimeException{
    private Integer code;

    public OpportunityException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
