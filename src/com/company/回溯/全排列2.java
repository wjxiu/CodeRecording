package com.company.回溯;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-17 13:23
 */
public class 全排列2 {
    public static void main(String[] args) {
        System.out.println(new 全排列2().permuteUnique1(new int[]{1, 1, 2,3,4,5,6,7}));
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

    public List<List<Integer>> permuteUnique1(int[] nums){
        Arrays.sort(nums);
        used=new boolean[nums.length];
        back1(nums);
//        System.out.println(res);
        return res;
    }
    void back1(int[] nums){
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            if (!used[i]){
                used[i]=true;
                path.add(nums[i]);
                back1(nums);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
