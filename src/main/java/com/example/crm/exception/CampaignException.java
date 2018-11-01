package com.example.crm.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:38
 * @ Description：活动操作异常类
 * @ Modified By：
 */
public class CampaignException extends RuntimeException {
    private Integer code;

    public CampaignException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
