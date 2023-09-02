package com.company.栈;

import java.util.ArrayDeque;

/**
 * @author xiu
 * @create 2023-09-02 21:28
 */
public class SortedStack {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.push(5);
        sortedStack.push(3);
        System.out.println(sortedStack.peek());
        sortedStack.pop();
        sortedStack.pop();
        System.out.println(sortedStack.peek());
    }
    ArrayDeque<Integer> main;
    ArrayDeque<Integer> temp;

    public SortedStack() {
        main = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }

    public void push(int val) {
        if (main.isEmpty()) main.push(val);
        else {
            while (!main.isEmpty()&&val > main.peek()) {
                temp.push(main.pop());
            }
            main.push(val);
            while (!temp.isEmpty()) {
                main.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (main.isEmpty()) return;
        main.pop();
    }

    public int peek() {
        if (main.isEmpty()) return -1;
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }
}
