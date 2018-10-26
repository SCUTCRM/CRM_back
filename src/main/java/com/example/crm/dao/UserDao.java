package com.example.crm.dao;

import com.example.crm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/25 14:56
 * @ Description：用户数据库访问层接口
 * @ Modified By：
 */
@Component
public interface UserDao {
    /**
     * create by: Bin Liu
     * description:根据用户姓名查询登录用户,登录时用,需判断用户是否锁定和密码是否正确
     * create time: 14:57 2018/10/25
     * 
      * @Param: null
     * @return 
     */
    User getUser(@Param("userName") String userName);
    
    /**
     * create by: Bin Liu
     * description:插入一条用户信息
     * create time: 14:59 2018/10/25
     * 
      * @Param: user 用户实体类
     * @return 
     */
    int insertUser(User user);
    /**
     * create by: Bin Liu
     * description:更新一条用户信息
     * create time: 14:59 2018/10/25
     * 
      * @Param: null
     * @return 
     */
    int updateUser(User user);
}
