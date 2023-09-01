package com.company.栈;

import java.util.ArrayDeque;

/**
 * 辅助栈
 * @author xiu
 * @create 2023-09-01 19:48
 */
public class MinStack {
    ArrayDeque<Integer> main;
    ArrayDeque<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        main=new ArrayDeque<>();
        min=new ArrayDeque<>();
    }

    public void push(int x) {
        main.push(x);
        if (min.isEmpty()) min.push(x);
        else{
            min.push(Math.min(min.peek(),x));
        }
    }

    public void pop() {
        main.pop();
        min.pop();
    }

    public int top() {
       return  main.peek();
    }

    public int getMin() {
        return min.peek();
    }
}