package com.company.RegExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 20:46
 */
public class REG05 {
    public static void main(String[] args) {
        String seq="1233423312";
        String reg="\\d+?";
        TEST(seq,reg);
        reg="\\d+";
        TEST(seq,reg);

    }
    static void TEST(String seq,String reg){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(seq);
        while (matcher.find()) {
            System.out.println(matcher.group()+" "+"total");
        }
        System.out.println("-----------------------");
    }
}
