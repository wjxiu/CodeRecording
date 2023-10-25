package com.company.RegExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 16:53
 */
public class REG02 {
    public static void main(String[] args) {
        String reg="";
//        reg= "\\d+";//匹配任意两个连在一起的数字
//        reg= "\\w+";//匹配任意两个连在一起的数字
//        reg= "\\s";//匹配任意两个连在一起的数字
//         reg= "\\D";//匹配任意两个连在一起的数字
//         reg= "\\W";//匹配任意两个连在一起的数字
         reg= ".";//匹配任意两个连在一起的数字
        String seq="\n\n678\nfg";
        TEST(seq,reg);
    }
    static void TEST(String seq,String reg){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(seq);
        while (matcher.find()) {
            System.out.print(matcher.group()+" "+"----");
        }
    }
}
