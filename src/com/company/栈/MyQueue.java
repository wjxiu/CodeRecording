package company.栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiu
 * @create 2023-07-27 22:17
 */
public class MyQueue {
    public static void main(String args[]) {
        int[] arr=new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        int[] otherarr=new int[arr.length];
        long l = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            otherarr[i]=arr[i];
        }
        System.out.print("for "+String.valueOf(System.currentTimeMillis() - l));
        otherarr=new int[arr.length];
        long l1 = System.currentTimeMillis();
        System.arraycopy(arr,0,otherarr,0,arr.length);
        System.out.print("System.arraycopy "+String.valueOf(System.currentTimeMillis() - l1));
        long l2 = System.currentTimeMillis();
        Arrays.copyOf(arr,arr.length);
        System.out.print("Arrays.copyOf "+String.valueOf( System.currentTimeMillis() - l2));
        long l3 = System.currentTimeMillis();
        arr.clone();
        System.out.print("clone "+String.valueOf(System.currentTimeMillis() - l3));
    }
//    public static void main(String[] args) {
////        "MyQueue", "push", "push", "peek", "pop", "empty"]
////[[], [1], [2], [], [], []]
//        MyQueue myQueue = new MyQueue();
//
//        System.out.println(myQueue.peek());
////        System.out.println(myQueue.pop());
//        while (!myQueue.empty()) {
//            System.out.println(myQueue.pop());
//        }
//        System.out.println(myQueue.empty());
//    }

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
