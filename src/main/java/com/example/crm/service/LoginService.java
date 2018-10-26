package com.example.crm.service;

import com.example.crm.dto.LoginResult;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 11:41
 * @ Description：登录业务逻辑接口
 * @ Modified By：
 */
public interface LoginService {
    /**
     * create by: Bin Liu
     * description: 用户可根据姓名 + password登录
     * create time: 2018/10/26 11:41
     * @Param: null
     * @return
     */
    LoginResult loginByUser(String userName, String passWord);
}
