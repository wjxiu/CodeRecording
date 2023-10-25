package com.company.RegExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 17:04
 */
public class REG03 {
    public static void main(String[] args) {
        String seq="my total money is 0010000000" +
                "you money just 123,   124,125,234,125,847,54";
        String reg="(?<g1>\\d{2})(?<g2>\\d{3})";
        TEST(seq,reg);
    }
    static void TEST(String seq,String reg){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(seq);
        while (matcher.find()) {
            System.out.println(matcher.group()+" "+"total");
            System.out.println(matcher.group("g1")+" group 1");
            System.out.println(matcher.group("g2")+" group 2");
        }
    }
}
