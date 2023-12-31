package com.company.回溯.排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-17 10:57
 */
public class 全排列 {
    public static void main(String[] args) {
        System.out.println(new 全排列().permute1(new int[]{1, 2, 3}));
    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList<>();
    boolean used[];
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        back(nums);
        System.out.println(res);
        return res;
    }
    void back(int[] nums){
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;
            path.add(nums[i]);
            used[i]=true;
            back(nums);
            path.removeLast();
            used[i]=false;
        }
    }

    public List<List<Integer>> permute1(int[] nums){
        used=new boolean[nums.length];
        back2(nums);
        return res;
    }
    void back1(int[] nums){
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i]=true;
            back1(nums);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }


    void back2(int[] nums){
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;
            path.add(nums[i]);
            used[i]=true;
            back2(nums);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
}
