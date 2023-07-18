package company.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-17 10:43
 */
public class 递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        back(nums,0);
        return res;
    }
    void back(int[] nums,int index){
        if (path.size()>=2){
            res.add(new LinkedList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (path.getLast()> num ||set.contains(num)) continue;
            path.add(num);
            set.add(num);
            back(nums, i+1);
            path.removeLast();
        }
    }
}
