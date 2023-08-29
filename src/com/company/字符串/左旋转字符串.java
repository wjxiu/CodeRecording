package company.字符串;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-12 12:47
 */
public class 左旋转字符串 {
    public static void main(String[] args) {
    }
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,s.length()-1);
        reverse(chars,0,s.length()-1);
        return new String(chars);
    }
    void reverse(char[] chars,int start,int end){
        while (start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

}
