package com.company.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-11 10:49
 */
public class 三数之和 {
    public static void main(String[] args) {
        System.out.println(new 三数之和().threeSum1(new int[]{-1,0,1,1,-1,0}));
        System.out.println(new 三数之和().threeSum1(new int[]{0,1,1}));
    }    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0]>0||nums.length<3) return result;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==0){
                    result.add( Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    right--;
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int left=i+1;
            int right=nums.length-1;
//            a去重
            if (i>0&&nums[i]==nums[i-1]) continue;
            while (left<right){
              int  sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    b去重
                    while (left<right&&nums[left]==nums[left+1]) left++;
//                    c去重
                    while (left<right&&nums[right]==nums[right-1]) right--;
//                    这个是没有去重也要做的
                    right--;
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
