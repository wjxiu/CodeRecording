package com.company.数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-11-13 12:46
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4,5});
    }
    static public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];res[0]=1;
        int temp=1;
        for (int i = 1; i < nums.length; i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i >=0; i--){
            temp*=nums[i+1];
            res[i]*=temp;
        }
        return res;
    }

}
