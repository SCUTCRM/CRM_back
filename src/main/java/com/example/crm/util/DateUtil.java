package com.example.crm.util;

import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/5 15:59
 * @ Description：日期操作工具类
 * @ Modified By：
 */
public class DateUtil {
    public static long getDifferenceSeconds(Date begin, Date end) {
        long result = (end.getTime() - begin.getTime()) / 1000;
        return result;
    }
}
