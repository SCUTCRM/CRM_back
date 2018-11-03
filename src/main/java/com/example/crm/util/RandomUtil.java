package com.example.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 10:03
 * @ Description：生成随机数工具类
 * @ Modified By：
 */
public class RandomUtil {
    //时间 + 五位随机数
    public static String getRandomFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = format.format(date);
        Random random = new Random();
        int rannum = (int)(random.nextDouble() * (99999 - 10000 + 1)) + 10000; //获取五位随机数
        return rannum + str;
    }

    //UUID方式
    public static String getRandomOrderId() {
        //随机生成一位整数
        int random = (int)(Math.random() * 9 + 1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if (hashCode < 0) {
            hashCode = - hashCode;
        }
        String value = "TYBX" + valueOf + String.format("%010d",hashCode);
        return value;
    }

    public static String generaterNumberOfSix(){
        return String.valueOf((int)((Math.random()*9 + 1) * 100000));
    }
}
