package com.company.单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-24 20:09
 */
public class 下一个更大元素II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 下一个更大元素II().nextGreaterElements(new int[]{1,2,3,4,3})));
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] res=new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Arrays.fill(res,-1);
        for (int i = 1; i < nums.length*2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty()&& num >nums[stack.peek()]){
                Integer pop = stack.pop();
                res[pop]=nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
