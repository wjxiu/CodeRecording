package com.company.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiu
 * @create 2023-07-17 9:17
 */
public class 子集 {
    public static void main(String[] args) {
        System.out.println(new 子集().subsets(new int[]{1, 2, 3}));
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back2(nums,0);
        return res;
    }
    void back(int[] nums,int index){
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            back(nums, i+1);
            path.removeLast();
        }
    }
    void back1(int[] nums,int index){
       res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            back1(nums, i+1);
            path.remove(path.size()-1);
        }
    }




    void back2(int[] nums,int index){
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            back2(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
