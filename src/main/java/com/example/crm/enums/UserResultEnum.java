package com.example.crm.enums;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 10:20
 * @ Description：用户操作相关结果枚举类
 * @ Modified By：
 */
public enum UserResultEnum {
    INPUT_NULL(-1,"输入信息为空"),
    USER_NOT_EXIT(-2,"用户信息不存在"),
    FAILD(-3,"更新数据失败"),
    SUCCESS(1,"操作成功");

    UserResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
