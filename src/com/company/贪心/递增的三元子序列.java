package com.company.贪心;

/**
 * @author xiu
 * @create 2023-11-14 13:23
 */
public class 递增的三元子序列 {
    static boolean increasingTriplet(int[] nums) {
        if (nums.length<3)return false;
        int left=nums[0];
        long second=Long.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>second)return true;
            else{
                if (nums[i]>left) second= nums[i];
            }
            if (nums[i]<left)left=nums[i];
        }
        return false;
    }
}
