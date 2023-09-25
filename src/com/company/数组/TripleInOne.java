package com.company.数组;

/**
 * @author xiu
 * @create 2023-09-01 19:04
 */
public class TripleInOne {
    Integer[] stack;
    int[] tail;
    int size;

    public TripleInOne(int stackSize) {
        size = stackSize;
        stack = new Integer[stackSize * 3];
        tail = new int[]{0, stackSize, 2 * stackSize};
        for (int i = 0; i < 3; i++) {
            tail[i]=stackSize*i;
        }
    }

    public void push(int stackNum, int value) {
       int idx=tail[stackNum];
       if (idx<tail[stackNum+1]){
           stack[idx]=value;
           tail[stackNum]++;
       }
    }

    public int pop(int stackNum) {
        int last=tail[stackNum];
        if (last > stackNum*size) {
            last--;
            return stack[last];
        }
        return -1;

    }

    public int peek(int stackNum) {
        int last=tail[stackNum];
        if (last>stackNum*size) {
            return stack[last-1];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return tail[stackNum] == stackNum*size;
    }
}

