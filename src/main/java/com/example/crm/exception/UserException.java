package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 10:25
 * @ Description：用户操作相关异常类
 * @ Modified By：
 */
public class UserException extends RuntimeException{
    private Integer code;

    public UserException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
