package com.company.RegExample.EXER;

/**
 * @author xiu
 * @create 2023-10-20 22:36
 */
public class EXER03 {
    public static void main(String[] args) {
        String s = "[ 1,2,3,4,5,5333333]".replaceAll("\\D+", "");
        System.out.println(s);
        System.out.println(s.matches("1[23456]\\d{8}"));
        String s1 = "zhangsnasdklfjk234324234l".replaceAll("[^a-zA-z]", "");
        String s2 = "zhangsnasdklfjk234324234l".replaceAll("[^a-zA-z]", "");
        System.out.println(s1);
    }
}
