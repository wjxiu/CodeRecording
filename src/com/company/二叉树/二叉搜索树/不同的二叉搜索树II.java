package com.company.二叉树.二叉搜索树;

import com.company.公共类.ListNode;
import com.company.公共类.TreeNode;
import com.company.公共类.工具类.LeetCodeUtils;

import java.util.*;

/**
 * @author xiu
 * @create 2023-11-08 13:36
 */
public class 不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        return gene(0, n);
    }

    List<TreeNode> gene(int a, int b) {
        List<TreeNode> list = new ArrayList<>();
        if (a > b || a < 0 || b < 0) {
            list.add(null);
            return new ArrayList<>();
        }
        if (a == b) return List.of(new TreeNode(a));
        for (int i = a; i <= b; i++) {
            List<TreeNode> left = gene(a, i - 1);
            List<TreeNode> right = gene(i + 1, b);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

//    public List<List<String>> partition(String s) {
    //        List<List<String>> res=new ArrayList<>();
//        boolean[][]dp=new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]);
//                if (dp[i][j]){
//
//                }
//            }
//        }
//    }

    static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String s1 : wordDict) {
                if (i < s1.length()) continue;
                String substring = s.substring(i - s1.length(), i);
                if (wordDict.contains(substring) && dp[i - s1.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
