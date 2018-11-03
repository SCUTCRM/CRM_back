package com.example.crm.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 15:37
 * @ Description：阿里云发送短信的工具类
 * @ Modified By：
 */
public class CodeUtil {
    //产品域名，开发者无需替换
    private static final String PRODUCT = "Dysmsapi";
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";
    //此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String ACCESSKEY_ID = "LTAIoXZgPqn8D5Wr";
    private static final String ACCESSKEY_SECRET = "BZv8WgsFAJgYHIUubuuE1QmZKITaGz";

    /**
     * create by: Bin Liu
     * description: 根据传入的电话号码和验证码发送验证码短信
     * create time: 2018/11/3 16:01
     * @Param: requestId 请求ID; bizId 发送回执ID; code 状态码-返回OK代表请求成功; message 状态码的描述;
     * @return 
     */
    public static SendSmsResponse sendSms(String phoneNumber,String code) throws ClientException {
        //如果不设置超时（timeout），在网络异常的情况下，可能会导致程序僵死而不继续往下执行。
        System.setProperty("sun.net.client.defaultConnectTimeout","30000"); //连接主机的超时时间
        System.setProperty("sun.net.client.defaultReadTimeout","30000");//从主机读取数据的超时时间
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESSKEY_ID, ACCESSKEY_SECRET);//分别填写自己的AccessKey ID和Secret
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);//不必修改
        IAcsClient acsClient = new DefaultAcsClient(profile);//不必修改
        SendSmsRequest request = new SendSmsRequest();//不必修改
        request.setPhoneNumbers(phoneNumber);//此处填写接收方的手机号码
        request.setSignName("刘斌");//此处填写已申请的短信签名
        request.setTemplateCode("SMS_140727023");//此处填写获得的短信模版CODE
        request.setTemplateParam("{\"code\":\""+code+"\"}");//笔者的短信模版中有${code}, 因此此处对应填写验证码
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);//不必修改
        return sendSmsResponse;
    }
}
