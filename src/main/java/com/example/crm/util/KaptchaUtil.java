package com.example.crm.util;


import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 16:38
 * @ Description：验证码验证工具类
 * @ Modified By：
 */
public class KaptchaUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){
        //从session中获取验证码
        String verifyCode= (String) request.getSession().getAttribute("verifyCode");
        //前端传过来得验证码
        String parameter = HttpServletRequestUtil.getString(request,"verifyCode");
        if(parameter==null||!parameter.equals(verifyCode)){
            return false;
        }
        return true;
    }
}
