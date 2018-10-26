package com.example.crm.enums;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 10:26
 * @ Description：${description}
 * @ Modified By：
 */
public enum SystemErrorEnum {
    SYSTEM_INNER_ERROR(-1001,"系统内部错误,操作失败"),
    CAPTCHA_GET_SUCCESS(1,"信息获取成功"),
    INPUT_NULL_ERROR(-1003,"信息输入为空");

    private Integer code;
    private String msg;

    SystemErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
