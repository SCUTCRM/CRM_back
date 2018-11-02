package com.example.crm.web;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/2 10:30
 * @ Description：获取验证码控制层
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class KaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    //获取图片验证码
    @GetMapping("/kaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response){
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try{
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("verifyCode",createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = null;
        try {
            responseOutputStream = response.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //这里是无法进行异常处理的，因为直接用url方式访问的，没有返回值
            if (responseOutputStream != null){
                try {
                    responseOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
