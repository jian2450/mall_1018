package com.atguigu.utils;

import java.math.BigDecimal;

/**
 * @author jian
 * @create 2022-07-24 16:40
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        //初始化
        BigDecimal b1 = new BigDecimal("0.02");
        BigDecimal b2 = new BigDecimal(0.02d);
        BigDecimal b3 = new BigDecimal(0.02f);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        //比较大小
        int compareTo = b2.compareTo(b3);
        System.out.println(compareTo);

        //运算
        BigDecimal b6 = new BigDecimal("6");
        BigDecimal b7 = new BigDecimal("7");
        BigDecimal add = b6.add(b7);
        System.out.println(add);
        BigDecimal subtract = b6.subtract(b7);
        System.out.println(subtract);
        BigDecimal multiply = b6.multiply(b7);
        System.out.println(multiply);
        System.out.println("***************************");

        //取舍 .异常
//        BigDecimal divide = b6.divide(b7);
//        System.out.println(divide);

        BigDecimal divide = b6.divide(b7, 2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(divide);


    }
}
