package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 11:39
 * @ Description：登陆逻辑异常类
 * @ Modified By：
 */
public class LoginException extends RuntimeException{
    private Integer code;

    public LoginException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
