package com.company.堆;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author xiu
 * @create 2023-11-03 20:56
 */
public class 第k个数 {
    public static void main(String[] args) {
    }

    static int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }
}
