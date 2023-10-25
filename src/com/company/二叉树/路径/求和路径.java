package com.company.二叉树.路径;

import com.company.公共类.TreeNode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiu
 * @create 2023-10-25 18:51
 */
public class 求和路径 {
    public static void main(String[] args) {
        System.out.println(pathSum(TreeNode.geneTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
//        计算本次的，和自己的左右子树
        return totalPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
//    计算root的路径和为sum的条数
    static int totalPath(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        int res = 0;
        if (sum == 0) res += 1;
        int left = totalPath(root.left, sum);
        int right = totalPath(root.right, sum);
        return res + left + right;
    }

    //    前缀树
    public static int pathSum1(TreeNode root, int sum) {
        HashMap<Long, Integer> hashmap = new HashMap<>();
        hashmap.put(0L, 1);
        return prefixTree(root, 0L, sum, hashmap);
    }

    public static int prefixTree(TreeNode root, Long curr, int sum, Map<Long, Integer> map) {
        if (root == null) return 0;
        curr += root.val;
//        因为已经将root.val的值加入了，所以下面的是curr-sum
        int res1 = map.getOrDefault(curr - sum, 0);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        res1 += prefixTree(root.left, curr, sum, map);
        res1 += prefixTree(root.right, curr, sum, map);
        map.put(curr, map.getOrDefault(curr, 0) - 1);
        return res1;
    }
}
