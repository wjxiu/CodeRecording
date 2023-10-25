package com.company.RegExample.EXER;

/**
 * @author xiu
 * @create 2023-10-20 22:46
 */
public class HOME {
    public static void main(String[] args) {
//        email
        String s="225533@c.g  yuiojkj";
        System.out.println(s.matches("[\\w-]+@([a-zA-Z]\\.)+[a-zA-Z]+"));
    }
}
class Home2{
    public static void main(String[] args) {
//        email
        String s="+10.544";
        System.out.println(s.matches("(([+-]?[1-9])?\\d*|0?)(\\.\\d+)?"));
    }
}