package com.example.crm.service.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.dto.RegisterResult;
import com.example.crm.entity.User;
import com.example.crm.enums.RegisterResultEnum;
import com.example.crm.exception.RegisterException;
import com.example.crm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 15:17
 * @ Description：注册逻辑实现类
 * @ Modified By：
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public RegisterResult register(User user) throws RegisterException {
        RegisterResult result = new RegisterResult();
        //判断输入是否为空
        if (user == null ) {
            result.setCode(RegisterResultEnum.INPUT_NULL.getCode());
            result.setMsg(RegisterResultEnum.INPUT_NULL.getMsg());
            return result;
        }
        try {
            //插入用户信息，其实这里就是为了简便，不再捕获系统可能出现的异常，更复杂的逻辑是先判断用户是否存在，再去判断是否出现系统异常
            if (userDao.insertUser(user) == 1){
                result.setCode(RegisterResultEnum.SUCCESS.getCode());
                result.setMsg(RegisterResultEnum.SUCCESS.getMsg());
            } else {
                result.setCode(RegisterResultEnum.USER_FAILD.getCode());
                result.setMsg(RegisterResultEnum.USER_FAILD.getMsg());
            }
            //System.out.println(1/0); 加上Transactional可以出错回滚
            return result;
        } catch (Exception ex) {
            throw new RegisterException(RegisterResultEnum.USER_EXIST.getCode(), RegisterResultEnum.USER_EXIST.getMsg());
        }
    }
}
