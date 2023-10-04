package com.company.单调栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-24 20:44
 */
public class 接雨水 {
    public static void main(String[] args) {
        System.out.println(new 接雨水().trap(new int[]{4,2,0,3,2,5}));
    }
    public int trap(int[] height) {
//        栈顶到栈底是递增的
        Stack<Integer> stack = new Stack<>();
        int res=0;
//        存的是索引
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int right = height[i];
            while (!stack.isEmpty()&& right >height[stack.peek()]){
//                中间的高度
                Integer mid = height[stack.pop()];
                if (!stack.isEmpty()){
//                    左边的索引
                    Integer leftindex = stack.peek();
//                    雨水的高度
                    int h = Math.min(height[leftindex], right)-mid;
//                    雨水的宽度
                    int w=i- leftindex -1;
                    res+=h*w;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
