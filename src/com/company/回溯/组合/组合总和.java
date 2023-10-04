package com.company.回溯.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 18:54
 */
public class 组合总和 {
    public static void main(String[] args) {
        System.out.println(new 组合总和().combinationSum1(new int[]{2, 3, 6, 7}, 7));
    }
    List<List<Integer>>  res = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer>  path=new LinkedList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        back(candidates,target,0);
        back1(candidates,target,0);
        return res;
    }
    void back1(int [] candidates,int target,int index){
        if (sum>target) return;
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum+=candidates[i];
            path.add(candidates[i]);
            back1(candidates,target,index);
            index++;
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }


    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        back2(candidates,target,0);
        return res;
    }
//    如果去掉index的话，会导致结果重复，因为没有对元素的访问顺序限制
//    由于这题的元素是不重复的所以只需要使用index控制每次递归的的开始访问顺序
    void back2(int[]candidates,int target,int index){
        if (sum>target) return;
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
                sum+=candidates[i];
                path.add(candidates[i]);
                back2(candidates,target,i);
                sum-=candidates[i];
                path.remove(path.size()-1);
            }
        }
    }
