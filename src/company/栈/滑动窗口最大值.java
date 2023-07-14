package company.栈;


import java.util.*;

/**
 * @author xiu
 * @create 2023-07-14 14:16
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 滑动窗口最大值().maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4)));
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