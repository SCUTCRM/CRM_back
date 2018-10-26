package com.example.crm.dto;

import com.example.crm.entity.User;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 9:37
 * @ Description：用户传输层实体类
 * @ Modified By：
 */
public class UserResult {
    private Integer code;
    private String msg;
    private User user;
    private List<User> userList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
