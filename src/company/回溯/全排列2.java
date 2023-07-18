package company.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-17 13:23
 */
public class 全排列2 {
    public static void main(String[] args) {
        System.out.println(new 全排列2().permuteUnique(new int[]{1, 1, 2}));
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
        back(nums);
        return res;
    }
    void back(int[] nums){
        if (path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
           if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
           if (!used[i]){
               path.add(nums[i]);
               used[i]=true;
               back(nums);
               used[i]=false;
               path.removeLast();

           }
        }
    }
}
