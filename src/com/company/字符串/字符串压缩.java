package com.company.字符串;

/**
 * @author xiu
 * @create 2023-08-29 18:23
 */
public class 字符串压缩 {
    public static void main(String[] args) {
        System.out.println(new 字符串压缩().compressString(""));
    }
    public String compressString(String S) {
        if (S.length()<2) return S;
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = S.toCharArray();
        int left=0;
        int right=1;
        while (left<right){
            if (right==charArray.length){
                stringBuffer.append(charArray[left]).append(right-left);
                break;
            }
            if (charArray[left]!=charArray[right]){
                stringBuffer.append(charArray[left]).append(right-left);
                left=right;
            }
           right++;
        }
        return stringBuffer.toString().length()<S.length()?stringBuffer.toString():S;
    }
}
