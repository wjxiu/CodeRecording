package company.栈;


import java.util.*;

/**
 * @author xiu
 * @create 2023-07-14 14:16
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 滑动窗口最大值().maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 3)));
        System.out.println(Arrays.toString(new 滑动窗口最大值().maxSlidingWindow1(new int[]{-7,-8,7,5,7,1,6,0}, 3)));
    }
    //    自定义单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        MyQueue myQueue = new MyQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res.add(myQueue.peek());
        for(int i = k; i < n; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            int peek = myQueue.peek();
            res.add(peek);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    class MyQueue {

        Deque<Integer> deque = new LinkedList<>();
        void poll(int val) {
            if (!deque.isEmpty()&&val==deque.peek()){
                deque.pop();
            }
        }
        void add(int val){
            while (!deque.isEmpty()&&val>deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(val);
        }
        int peek(){
            return deque.getFirst();
        }
    }

//    自定义单调队列
    public int[] maxSlidingWindow1(int[] nums, int k){
        ArrayList<Integer> res = new ArrayList<>();
        MyQueue1 queue = new MyQueue1();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res.add(queue.peek());
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            res.add( queue.peek());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    class MyQueue1 {
       Deque<Integer> deque= new LinkedList<Integer>();
       public void add(int val){
           while (!deque.isEmpty()&&val>deque.getLast()){
               deque.removeLast();
           }
           deque.addLast(val);
       }
       public void remove(int val){
           if (deque.getFirst()==val) {
               deque.removeFirst();
           }
       }
       public int peek(){
         return   deque.getFirst();
       }
    }
}
