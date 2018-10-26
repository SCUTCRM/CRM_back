package com.example.crm.service;

import com.example.crm.dto.RegisterResult;
import com.example.crm.entity.User;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 11:40
 * @ Description：注册逻辑接口
 * @ Modified By：
 */
public interface RegisterService {
    /**
     * create by: Bin Liu
     * description: 用户注册
     * create time: 2018/10/26 11:40
     * @Param: null
     * @return
     */
    RegisterResult registerByUser(User user);
}
