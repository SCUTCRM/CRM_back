package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 11:38
 * @ Description：注册逻辑异常类
 * @ Modified By：
 */
public class RegisterException extends RuntimeException{
    private Integer code;

    public RegisterException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
