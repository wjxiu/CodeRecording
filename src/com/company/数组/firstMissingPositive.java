package com.company.数组;

/**
 * @author xiu
 * @create 2023-11-21 17:41
 */
public class firstMissingPositive {
    static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i]<=0)nums[i]= length;
        }
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs<=length){
                nums[abs-1]=-Math.abs(nums[abs-1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i]>=0)return i+1;
        }
        return length +1;
    }
}
