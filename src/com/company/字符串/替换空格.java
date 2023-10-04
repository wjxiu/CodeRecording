package com.company.字符串;

/**
 * @author xiu
 * @create 2023-07-12 10:30
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            if (c!=' '){
                stringBuilder.append(c);
            }else{
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }
}
