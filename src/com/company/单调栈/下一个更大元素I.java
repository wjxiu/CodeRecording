package com.company.单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-24 18:02
 */
public class 下一个更大元素I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 下一个更大元素I().nextGreaterElement(new int[]{ 1, 4}, new int[]{1,4,99,45})));
    }
    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >=0; i--) {
            while (!stack.isEmpty()&&nums2[i]>=stack.peek()){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num=nums1[i];
            res[i]=map.get(num);
        }
        return  res;
    }


    //暴力
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            for (int j = integer; j < nums2.length; j++) {
                if (nums2[j]>nums1[i]){
                    res[i]=nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
