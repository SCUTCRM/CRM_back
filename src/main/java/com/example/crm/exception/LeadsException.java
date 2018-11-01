package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:40
 * @ Description：线索操作异常类
 * @ Modified By：
 */
public class LeadsException extends RuntimeException {
    private Integer code;

    public LeadsException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
