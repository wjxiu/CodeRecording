package com.company.回溯.排序;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * @author xiu
 * @create 2023-07-17 13:23
 */
public class 全排列2 {
    public static void main(String[] args) {
        System.out.println(new 全排列2().permuteUnique1(new int[]{1,1,2}));
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
        back2(nums);
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



    void back2(int[] nums){
        if (path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
//        因为是排序问题，所以不用index，从0开始遍历，但是需要used数组去重，保证不能重复访问元素
        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;
//            这个是防止遍历树的每一层防止重复选择，例如数组1,1,2  如果遍历到第二个1，那么不应该继续执行代码，
//            因为要返回不重复的排序,使用这个去重操作前提是数组已经排序了
            if ((i>0&&nums[i]==nums[i-1]&&!used[i-1])){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            back2(nums);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
}
