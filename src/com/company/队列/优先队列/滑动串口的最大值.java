package com.company.队列.优先队列;

import com.company.公共类.TreeNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-11-19 19:57
 */
public class 滑动串口的最大值 {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,-9,8,-6,6,4,0,5},4);
    }
    static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{i, nums[i]});
            if (i >= k - 1) {
                while (!queue.isEmpty()&& queue.peek()[0]<=i-k){
                     queue.poll();
                }
                list.add(queue.peek()[1]);
            }
        }
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
