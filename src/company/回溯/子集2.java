package company.回溯;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-17 9:33
 */
public class 子集2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        back(nums,0,used);
        return res;
    }
    void back(int[] nums,int index,boolean used[]){
        res.add(new ArrayList<>(path));
        for (int i = index; i <nums.length; i++) {
            if (i>0&&nums[i-1]==nums[i]&& !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            back(nums, i+1,used);
            path.removeLast();
            used[i]=false;
        }
    }
}