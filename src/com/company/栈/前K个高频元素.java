package company.栈;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author xiu
 * @create 2023-07-14 15:13
 */
public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
//        k:值 v:频率
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
//        大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1,a2)->{
            return a2[1]-a1[1];
        });
        Set<Integer> keys = map.keySet();
        keys.forEach(i->{
            Integer val = map.get(i);
            queue.add(new int[]{i,val});
        });
//        取出前k个元素
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            res[i]=poll[0];
        }
        return res;
    }
}
