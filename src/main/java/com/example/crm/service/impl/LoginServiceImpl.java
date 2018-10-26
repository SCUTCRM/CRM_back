package com.example.crm.service.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.dto.LoginResult;
import com.example.crm.entity.User;
import com.example.crm.enums.LoginResultEnum;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.LoginException;
import com.example.crm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 15:24
 * @ Description：登陆逻辑实现类
 * @ Modified By：
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public LoginResult loginByUser(String userName, String passWord) {
        LoginResult loginResult = new LoginResult();
        if (userName == null || passWord == null){
            loginResult.setCode(LoginResultEnum.INPUT_NULL.getCode());
            loginResult.setMsg(LoginResultEnum.INPUT_NULL.getMsg());
            return loginResult;
        }
        try{
            User u = userDao.getUser(userName);
            if (u == null){  //用户是否存在
                loginResult.setCode(LoginResultEnum.USER_NOT_EXIT.getCode());
                loginResult.setMsg(LoginResultEnum.USER_NOT_EXIT.getMsg());
            } else if (null != u.getPassWord() && !u.getPassWord().equals(passWord)){  //用户名密码是否一致
                loginResult.setCode(LoginResultEnum.NOT_MATCH.getCode());
                loginResult.setMsg(LoginResultEnum.NOT_MATCH.getMsg());
            } else{
                loginResult.setCode(LoginResultEnum.SUCCESS.getCode());
                loginResult.setMsg(LoginResultEnum.SUCCESS.getMsg());
                loginResult.setUser(u);
            }
            return loginResult;
        }catch (Exception e){
            throw new LoginException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(),SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }
}
