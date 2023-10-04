package com.company.数组;

/**
 * @author xiu
 * @create 2023-07-25 17:04
 */
public class 二分查找 {
    public static void main(String[] args) {
        System.out.println(new 二分查找().search(new int[]{-1,0,3,5,9,12}, 2));
    }
    public int search(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        while (left<=right){
            int midIndex = (right + left) / 2;
            int mid=nums[midIndex];
            if (target==mid) return midIndex;
            if (target>mid){
                left=midIndex+1;
            }else{
                right=midIndex-1;
            }
        }
        return -1;
    }
}
