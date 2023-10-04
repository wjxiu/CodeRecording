package com.company.回溯.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-16 18:02
 */
public class 组合3 {
    public static void main(String[] args) {
        System.out.println(new 组合3().combinationSum3_1(6, 13));
    }
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        back1(k,n,1);
        return res;
    }
    void back(int k,int n,int index){
        if (sum>n) return;
        if (path.size()==k&&sum==n){
            res.add(new ArrayList<>(path));
            return ;
        }
//        这里的i要从index开始，如果从1开始，那么下一次也是从1开始，题目要求数字只能使用1次
        for (int i = index; i <= 9; i++) {
            path.add(i);
            sum+=i;
            back(k, n, i+1);
            path.remove(path.size()-1);
            sum-=i;
        }
    }


    void back1(int k,int n,int index){
        if (k==0&&sum==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <=9; i++) {
            sum+=i;
            path.add(i);
            back1(k-1,n,i+1);
            sum-=i;
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3_1(int k, int n){
        back3(k,n,1);
        return res;
    }
    void back3(int k,int n,int index){
        if (sum==n&&path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <=9; i++) {
            path.add(i);
            sum+=i;
            back3(k,n,i+1);
            path.remove(path.size()-1);
            sum-=i;
        }
    }
}
