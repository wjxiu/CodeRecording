package com.company.深度搜索;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * @author xiu
 * @create 2023-11-14 14:18
 */
public class 水壶问题 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(104693, 104701, 324244));
    }

    static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        Deque<int[]> stack = new ArrayDeque();
        HashSet<Long> set = new HashSet();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            if (set.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            set.add(hash(stack.peek()));
            int[] pop = stack.pop();
            int remainX = pop[0];
            int remainY = pop[1];
            if (remainX == targetCapacity || pop[1] == targetCapacity || remainX + remainY == targetCapacity)
                return true;
            //把 X 壶倒空；
            //把 Y 壶倒空。
            stack.push(new int[]{0, remainY});
            stack.push(new int[]{remainX, 0});
            //把 X 壶灌满；
            //把 Y 壶灌满；
            stack.push(new int[]{jug1Capacity, remainY});
            stack.push(new int[]{remainX, jug2Capacity});
//            把 X 壶的水灌进 Y 壶，直至灌满或倒空；
//          stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            int xlater = remainX - Math.min(remainY, jug2Capacity - remainY);
            int ylater = remainY + Math.min(remainY, jug2Capacity - remainY);
            stack.push(new int[]{xlater, ylater});
            //把 Y 壶的水灌进 X 壶，直至灌满或倒空；
            ylater = remainY - Math.min(remainY, jug1Capacity - remainX);
            xlater = remainX + Math.min(remainY, jug1Capacity - remainX);
            stack.push(new int[]{xlater, ylater});
        }
        return false;
    }

    static long hash(int[] arr) {
        return (long) (arr[0] * 1000001 + arr[1]);
    }
}

class RandomizedSet {
     HashMap<Integer, Integer> map = new HashMap<>();
    int[] arr = null;
    int size = 0;

    public RandomizedSet() {
        arr = new int[20010];
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[size] = val;
        map.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (map.get(val)==null)return false;
        int last = arr[size - 1];
        map.put(last, map.get(val));
        swap(arr, size - 1, map.get(val));
        size--;
        return map.remove(val) != null;

    }

    private void swap(int arr[], int idx, int idx1) {
        int temp = arr[idx];
        arr[idx] = arr[idx1];
        arr[idx1] = temp;
    }

    public int getRandom() {
        if (size == 1) return arr[0];
        Random random = new Random();
        int i1 = random.nextInt(size);
        return arr[i1];
    }
}
