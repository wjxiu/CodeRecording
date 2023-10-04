package com.company.单调栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-24 17:22
 */
public class 每日温度 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 每日温度().dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
    }

    //    单调栈存储温度索引做法
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop]=i-pop;
            }
            stack.push(i);
        }
        return res;
    }

    //    单调栈存储温度做法
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexstack = new Stack<>();
        stack.push(temperatures[0]);
        indexstack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && !indexstack.isEmpty() && temperature > stack.peek()) {
                Integer pop1 = indexstack.pop();
                Integer pop = stack.pop();
                res[pop1] = i - pop1;
            }
            stack.push(temperature);
            indexstack.push(i);
        }
        return res;
    }
}
