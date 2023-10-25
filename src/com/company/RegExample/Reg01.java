package com.company.RegExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 16:11
 */
public class Reg01 {
    public static void main(String[] args) {
//        String reg= "[a-z]";//匹配任意小写字母
//        String reg= "[A-Z]";//匹配任意大写字母
//        String reg= "[0-9]{2}";//匹配任意一个数字
        String reg= "a([0-9]{2})";//匹配任意两个连在一起的数字
        String seq="a7657";
       TEST(seq,reg);
    }
    static void TEST(String seq,String reg){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(seq);
        while (matcher.find()) {
            System.out.print(matcher.group()+" ");
        }
    }
}
