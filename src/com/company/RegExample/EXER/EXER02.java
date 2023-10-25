package com.company.RegExample.EXER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-20 22:14
 */
public class EXER02 {
    public static void main(String[] args) {
        String context="我我我...要学学学....变变变...程！！！";
        context=Pattern.compile("\\.").matcher(context).replaceAll("");
        System.out.println(context);
        String reg="(.)\\1+";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(context);
//        while (matcher.find()) {
//            System.out.println("找到了");
//            System.out.println(matcher.group());
//        }
        System.out.println(matcher.replaceAll("$1"));
    }
}
