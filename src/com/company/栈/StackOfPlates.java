package com.company.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 不会
 * @author xiu
 * @create 2023-09-01 19:56
 */
public class StackOfPlates {
    ArrayList<ArrayDeque<Integer>> all;
    int allSize;//下一个元素应该放的位置
    int stackSize;//每个栈的最大容量
    public StackOfPlates(int cap) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(cap);
        all.add(stack);
        allSize=0;
        stackSize=cap;
    }

//    public void push(int val) {
//        if (allSize/all.size()>stackSize){
//            ArrayDeque<Integer> stack = new ArrayDeque<>();
//            stack.push(val);
//            all.add(stack);
//            allSize
//        }
//    }
//
//    public int pop() {
//
//    }
//
//    public int popAt(int index) {
//
//    }
}
