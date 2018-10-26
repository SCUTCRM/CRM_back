package com.example.crm.service;

import com.example.crm.dto.UserResult;
import com.example.crm.entity.User;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 9:36
 * @ Description：用户业务逻辑接口
 * @ Modified By：
 */
public interface UserService {
    /**
     * create by: Bin Liu
     * description: 根据姓名判断用户是否存在
     * create time: 2018/10/26  10:07
     *
     * @Param:
     * @return
     */
    UserResult userExitOrNot(String userName);

    /**
     * create by: Bin Liu
     * description: 根据姓名获取用户信息
     * create time: 2018/10/26 10:08
     * 
     * @Param: null
     * @return 
     */
    UserResult getUser(String userName);

    /**
     * create by: Bin Liu
     * description: 更新一条数据
     * create time: 2018/10/26 10:15
     * @Param: null
     * @return 
     */   
    UserResult updateUser(User user);
}
