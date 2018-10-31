package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:30
 * @ Description：产品操作异常类
 * @ Modified By：
 */
public class ProductException extends RuntimeException{
    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
