package company.栈;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-27 22:17
 */
public class MyQueue {
    public static void main(String[] args) {
//        "MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
        MyQueue myQueue = new MyQueue();

        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
        while (!myQueue.empty()) {
            System.out.println(myQueue.pop());
        }
        System.out.println(myQueue.empty());
    }

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    private void flash() {
        if (in.empty()) return;
        while (!in.isEmpty()) out.push(in.pop());
    }

    public int pop() {
        flash();
        return out.pop();

    }

    public int peek() {
        flash();
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
