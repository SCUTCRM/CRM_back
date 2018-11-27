package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/26 20:07
 * @ Description：封装系统异常类
 * @ Modified By：
 */
public class SystemException extends RuntimeException{
    private Integer code;

    public SystemException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
