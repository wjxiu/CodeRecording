package com.company.栈;
import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-07-27 22:31
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
    LinkedList<Integer> mainQueue;
    LinkedList<Integer> backupQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        backupQueue = new LinkedList<>();
    }

    public void push(int x) {
        mainQueue.offer(x);
    }

    public int pop() {
        Integer first = null;
        while (mainQueue.size() >0) {
            if (mainQueue.size()==1){
                first=mainQueue.poll();
            }else{
                backupQueue.offer(mainQueue.poll());
            }
        }
        while (backupQueue.size() > 0) {
            mainQueue.offer(backupQueue.poll());
        }
        return first;
    }

    public int top() {
        Integer first = null;
        while (mainQueue.size() >0) {
            if (mainQueue.size()==1){
                first=mainQueue.getFirst();
            }
            backupQueue.offer(mainQueue.poll());
        }
        while (backupQueue.size() > 0) {
            mainQueue.offer(backupQueue.poll());
        }
        return first;
    }

    public boolean empty() {
        return mainQueue.isEmpty() && backupQueue.isEmpty();
    }
}
