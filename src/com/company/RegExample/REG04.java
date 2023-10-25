package com.company.RegExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 20:29
 */
public class REG04 {
    public static void main(String[] args) {
        String seq="awindows 2000 is good  bwindows 98 very good cwindows 10 super good dwindows NT extremely bad";
        String reg="[a-d]windows (?:2000|98|NT)";
        TEST(seq,reg);
         reg="[a-d]windows (?=2000|98|NT)";
        TEST(seq,reg);
         reg="[a-d]windows (?!2000|98|NT)";
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
