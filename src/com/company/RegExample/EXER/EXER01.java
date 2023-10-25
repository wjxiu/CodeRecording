package com.company.RegExample.EXER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 汉字
 * @author xiu
 * @create 2023-10-20 20:50
 */
public class EXER01 {
    public static void main(String[] args) {
        String seq="aa...vvvvv...ddee..ddsf.eeeeeee.hhdler".replaceAll("\\.","");
        String reg="";
         reg="^[\\u4e00-\\u9FA5]+$";//汉字范围
        reg="[1-9]\\d{5}";
        reg="[1-9]\\d{4,9}";
        reg="(\\d)(\\d)\\2\\1";
        reg="\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        reg="(\\w+)\\1+";
//        如 -、_、.、~ 等
//        reg="https*:\\/\\/([[\\w]+\\.\\-])+";
//        reg="https*:\\/\\/(www.)*(\\w{1,100})\\.\\d{3}(\\/)*[a-zA-Z0-9-_\\.~\\*%]{0,1024}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(seq);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("-----------------------");
    }
}
