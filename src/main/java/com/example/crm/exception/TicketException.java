package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:41
 * @ Description：售后服务操作异常类
 * @ Modified By：
 */
public class TicketException extends RuntimeException{
    private Integer code;

    public TicketException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
