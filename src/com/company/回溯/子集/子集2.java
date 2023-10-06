package com.company.回溯.子集;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-17 9:33
 */
public class 子集2 {
    public static void main(String[] args) {
        System.out.println(new 子集2().subsetsWithDup1(new int[]{4,4,4,1,4}));
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
//        back(nums,0,used);
        back1(nums,0,new HashSet<>());
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

    void back1(int[] nums,int index,Set<Integer> set){
        res.add(new ArrayList<>(path));
        for (int i = index; i <nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            used[i]=true;
            set.add(nums[i]);
            path.add(nums[i]);
            back1(nums, i+1,set);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        back2(nums,0);
        return res;
    }
    void back2(int[] nums,int index){
            res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            back2(nums,i+1);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
}