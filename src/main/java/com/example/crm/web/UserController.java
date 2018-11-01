package com.example.crm.web;

import com.example.crm.dto.UserResult;
import com.example.crm.enums.UserResultEnum;
import com.example.crm.exception.UserException;
import com.example.crm.service.UserService;
import com.example.crm.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 9:35
 * @ Description：用户操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    //判断用户是否存在
    @GetMapping("/users/usersexit")
    private HashMap<String,Object> userExitOrNot(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            String userName = HttpServletRequestUtil.getString(request,"userName");
            UserResult userResult = userService.userExitOrNot(userName);
            if (userResult.getCode() == UserResultEnum.SUCCESS.getCode()){
                resultMap.put("success",true);
                resultMap.put("user",userResult.getUser());
            } else {
                resultMap.put("success",false);
            }
            resultMap.put("code",userResult.getCode());
            resultMap.put("msg",userResult.getMsg());
        }catch (UserException e){
            resultMap.put("success",false);
            resultMap.put("msg",e.getMessage());
            resultMap.put("code",e.getCode());
        }
        return resultMap;
    }
}
