package com.company.数组;

/**
 * @author xiu
 * @create 2023-11-09 21:33
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left=0;int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[right]>nums[mid]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return nums[left];
    }
}
