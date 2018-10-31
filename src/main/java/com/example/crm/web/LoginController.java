package com.example.crm.web;

import com.example.crm.dto.LoginResult;
import com.example.crm.enums.LoginResultEnum;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.LoginException;
import com.example.crm.service.LoginService;
import com.example.crm.util.HttpServletRequestUtil;
import com.example.crm.util.KaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 15:35
 * @ Description：登录控制层实现类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //用户登录
    @PostMapping("/users/login")
    private HashMap<String,Object> loginByUser(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.判断验证码
        if (!KaptchaUtil.checkVerifyCode(request)){
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.KAPTCHA_INPUT_ERROR.getMsg());
            resultMap.put("code", SystemErrorEnum.KAPTCHA_INPUT_ERROR.getCode());
            return resultMap;
        }
        //根据前端传递的参数发起登录请求
        String userName = HttpServletRequestUtil.getString(request,"userName");
        String passWord = HttpServletRequestUtil.getString(request,"passWord");
        try{
            LoginResult result = loginService.loginByUser(userName,passWord);
            if (result.getCode() == LoginResultEnum.SUCCESS.getCode()){
                resultMap.put("success",true);
                //将user返回给前端之后需要使用
                resultMap.put("user",result.getUser());
            }else {
                resultMap.put("success",false);
            }
            resultMap.put("code",result.getCode());
            resultMap.put("msg",result.getMsg());
            //将用户信息存入session中
            if (result.getUser() != null) {
                request.getSession().setAttribute("user",result.getUser());
            }
        }catch (LoginException ex){
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
        }
        return resultMap;
    }

    @GetMapping("/logout")
    private HashMap<String,Object> logout(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute("user") != null) {
                session.removeAttribute("user");
            }
        }
        resultMap.put("success",true);
        return resultMap;
    }
}
