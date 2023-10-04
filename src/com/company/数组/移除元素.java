package com.company.数组;

import java.util.Arrays;

/**
 * @author xiu
 * @create 2023-07-09 15:43
 */
public class 移除元素 {
    public static void main(String[] args) {
        System.out.println(new 移除元素().removeElement2(new int[]{0, 1, 2, 3, 4, 5, 2, 4}, 2));
    }
//    快慢指针
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement1(int[] nums, int val) {
        int slow=0;
        int fast=0;
        while(fast<nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        return slow;
    }

    public int removeElement2(int[] nums, int val){
        int slow=0,fast=0;
        while (fast< nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
