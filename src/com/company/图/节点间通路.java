package com.company.图;

import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-09-02 22:35
 */
public class 节点间通路 {
    public static void main(String[] args) {
        System.out.println(new 节点间通路().findWhetherExistsPath(12,
                LeetCodeUtils.parseToIntArray(
                        "[[0, 1], [1, 2], [1, 3], [1, 10], [1, 11], [1, 4], [2, 4], [2, 6], [2, 9], [2, 10], [2, 4], [2, 5], [2, 10], [3, 7], [3, 7], [4, 5], [4, 11], [4, 11], [4, 10], [5, 7], [5, 10], [6, 8], [7, 11], [8, 10]]"),
                2, 3));
    }
    HashSet<Integer>[] adjustive;
    boolean[] visted;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        adjustive=new HashSet[n];
        for (int i = 0; i < n; i++) adjustive[i]=new HashSet<>();
        for (int[] edge : graph) if (edge[0] != edge[1]) adjustive[edge[0]].add(edge[1]);
        visted=new boolean[n];
       return  dfs(start,target);
    }

    private boolean dfs(int current,int target){
        if (!visted[current]){
            HashSet<Integer> list = adjustive[current];
            visted[current]=true;
            for(Integer num:list){
                if (!visted[num]&&dfs( num, target)) return true;
                visted[current]=false;
            }
        }
        return visted[target];
    }
}
