package com.company.RegExample.EXER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-10-23 15:23
 */
public class home1 {
    public static void main(String[] args) {
         String s= "[[1,2,3,4,5],[5,3,2,5,6],[1,3,5,6,745],[1,3,5,6,7,75]]";
        Pattern compile = Pattern.compile("\\[([^\\[\\]]+)\\]");
        Matcher matcher = compile.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
