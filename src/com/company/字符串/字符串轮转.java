package com.company.字符串;

/**
 * @author xiu
 * @create 2023-08-29 19:32
 */
public class 字符串轮转 {
    public static void main(String[] args) {
        double num=0.1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0.");
        for (int i = 0; i < 32&&num!=0; i++) {
            if (num*2>=1) {
                stringBuffer.append(1);
                num=num*2-1;
            }else{
                stringBuffer.append(0);
                num=num*2;
            }
        }
        if (num!=0)
        System.out.println(stringBuffer.toString());
    }
    public boolean isFlipedString(String s1, String s2) {
        double num=0.345;
        System.out.println(Double.doubleToLongBits(num));
        return (s2 + s2).contains(s1)&&s1.length()==s2.length();
    }
}
