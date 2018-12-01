package com.example.crm.service.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.dto.UserResult;
import com.example.crm.entity.User;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.enums.UserResultEnum;
import com.example.crm.exception.UserException;
import com.example.crm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 9:37
 * @ Description：用户业务逻辑实现类
 * @ Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> getUserList(Map map, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<User> list = userDao.getUserListByParams(map);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public UserResult userExitOrNot(String userName) {
        UserResult userResult = new UserResult();
        if (userName == null) {
            userResult.setCode(UserResultEnum.INPUT_NULL.getCode());
            userResult.setMsg(UserResultEnum.INPUT_NULL.getMsg());
            return userResult;
        }
        try {
            User user = userDao.getUser(userName);
            if (user == null) {
                userResult.setCode(UserResultEnum.USER_NOT_EXIT.getCode());
                userResult.setMsg(UserResultEnum.USER_NOT_EXIT.getMsg());
            }else {
                userResult.setCode(UserResultEnum.SUCCESS.getCode());
                userResult.setMsg(UserResultEnum.SUCCESS.getMsg());
                //设置user返回个前端使用
                userResult.setUser(user);
            }
            return userResult;
        } catch (Exception e) {
            throw new UserException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(), SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }

    @Override
    public UserResult getUser(String userName) {
        return null;
    }

    @Transactional
    @Override
    public UserResult updateUser(User user) {
        UserResult userResult = new UserResult();
        if (user == null) {
            userResult.setCode(UserResultEnum.INPUT_NULL.getCode());
            userResult.setMsg(UserResultEnum.INPUT_NULL.getMsg());
            return userResult;
        }
        try {
            //调用dao层更新数据
            int result = userDao.updateUser(user);
            if (result == 1){
                userResult.setCode(UserResultEnum.SUCCESS.getCode());
                userResult.setMsg(UserResultEnum.SUCCESS.getMsg());
            } else {
                userResult.setCode(UserResultEnum.FAILD.getCode());
                userResult.setMsg(UserResultEnum.FAILD.getMsg());
            }
            return userResult;
        }catch (Exception e){
            throw new UserException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(), SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }

    @Transactional
    @Override
    public int deleteUser(Integer id) {
        if (id == null) return 0;
        try {
            int result = userDao.deleteUser(id);
            if (result <= 0) return 0;
            return 1;
        } catch (Exception e) {
            throw new RuntimeException("删除失败");
        }
    }
}
