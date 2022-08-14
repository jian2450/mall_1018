package com.atguigu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jian
 * @create 2022-07-29 22:30
 */
public class MyDateUtil {

    public static void main(String[] args) {
        String str = MyDateUtil.getMyTime("yyyyMMddHHmmss");
        System.out.println(str);

        Date date = MyDateUtil.getMyDate(3);
        System.out.println(date);
    }

    public static String getMyTime(String format) {
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(new Date());
        return str;
    }

    public static Date getMyDate(int i) {
        //日期计算
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, i);

        return c.getTime();
    }
}
