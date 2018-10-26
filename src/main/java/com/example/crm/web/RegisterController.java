package com.example.crm.web;

import com.example.crm.dto.RegisterResult;
import com.example.crm.entity.User;
import com.example.crm.enums.RegisterResultEnum;
import com.example.crm.exception.RegisterException;
import com.example.crm.service.RegisterService;
import com.example.crm.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 15:36
 * @ Description：登录控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    //用户注册
    @PostMapping("/users/register")
    private HashMap<String,Object> registerByUser(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        //将前台获取的参数转换成User对象
        String userStr = HttpServletRequestUtil.getString(request,"user");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        //进行注册,user是由是由前端传递过来的json字符串
        try{
            RegisterResult result = registerService.registerByUser(user);
            if (result.getCode() == RegisterResultEnum.SUCCESS.getCode()){
                resultMap.put("success",true);
            }else{
                resultMap.put("success",false);
            }
            resultMap.put("code",result.getCode());
            resultMap.put("msg",result.getMsg());
            return resultMap;
        }catch (RegisterException e){
            resultMap.put("success",false);
            resultMap.put("code",e.getCode());
            resultMap.put("msg",e.getMessage());
            return resultMap;
        }
    }
}
