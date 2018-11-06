package com.example.crm.web;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.crm.contants.SessionAttributeContants;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.util.CodeUtil;
import com.example.crm.util.DateUtil;
import com.example.crm.util.HttpServletRequestUtil;
import com.example.crm.util.RandomUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/5 15:57
 * @ Description：获取短信验证码的控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class CaptchaController {
    //获取手机验证码
    @GetMapping("/captcha")
    private HashMap<String,Object> getCaptcha(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.获取手机号码
        String phone = HttpServletRequestUtil.getString(request,"phone");
        if (phone == null){
            resultMap.put("success",false);
            resultMap.put("msg",SystemErrorEnum.INPUT_NULL_ERROR.getMsg());
            resultMap.put("code",SystemErrorEnum.INPUT_NULL_ERROR.getCode());
            return resultMap;
        }
        //2.判断是否已经获取过验证码，并且验证码未过期
        String sessionCode = (String) request.getSession().getAttribute("code");
        Date sendTime = (Date) request.getSession().getAttribute("codeTime");
        if (sessionCode != null && sendTime != null){  //验证码已存在并且未过期
            long seconds = DateUtil.getDifferenceSeconds(sendTime,new Date());
            if (seconds < SessionAttributeContants.OVERDUESECONDS) {
                resultMap.put("success",false);
                resultMap.put("msg","验证码已发送，请勿重复获取");
                return resultMap;
            }
        }
        //3.发送短信(短时间内不能获取是前端按钮不可点击实现),并将短信验证码放入session中
        //获取六位随机数
        String code = RandomUtil.generaterNumberOfSix();
        HttpSession session = request.getSession();
        try {
            SendSmsResponse response = CodeUtil.sendSms(phone,code);
            if (response != null && response.getCode().equals("OK")) {
                resultMap.put("success",true);
                resultMap.put("msg",SystemErrorEnum.CAPTCHA_GET_SUCCESS.getMsg());
                resultMap.put("code",SystemErrorEnum.CAPTCHA_GET_SUCCESS.getCode());
                session.setAttribute("code", code);
                session.setAttribute("codeTime", new Date());
            } else {
                resultMap.put("success",false);
                resultMap.put("msg",response.getMessage());
                resultMap.put("code",response.getCode());
            }
            return resultMap;
        } catch (ClientException e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }
}
