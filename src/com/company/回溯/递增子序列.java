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
        back1(nums,0);
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


    void back1(int[] nums,int index){
        if (path.size()>1){
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            if (path.size()>0&&nums[i]<path.get(path.size()-1)||set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            back1(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
