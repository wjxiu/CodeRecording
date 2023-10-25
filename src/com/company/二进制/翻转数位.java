package com.company.二进制;

/**
 * @author xiu
 * @create 2023-10-26 20:16
 */
public class 翻转数位 {
    public int reverseBits(int num) {
        String binaryString = Integer.toBinaryString(num);
        while (binaryString.length()<32){
            binaryString="0"+binaryString;
        }
        int res=-1;
        int count=0;
        int left=0;int right=0;
        while (right<binaryString.length()){
            if (binaryString.charAt(right)=='0') count++;
            while (count>1){
                if (binaryString.charAt(left)=='0') count--;
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
