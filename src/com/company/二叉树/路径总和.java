package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.regex.Pattern;

/**
 * @author xiu
 * @create 2023-07-15 10:47
 */
public class 路径总和 {
    public static void main(String[] args) {
//        TreeNode root = TreeNode.geneTree(1, 2);
//        System.out.println(new 路径总和().hasPathSum(root, 1));
//        System.out.println(new 路径总和().hasPathSum(TreeNode.geneTree(1, 2, 34, 5, 5, 6, 4, 7, 5, 3, 2), 11));
//        System.out.println(new 路径总和().hasPathSum(TreeNode.geneTree(1, 2, 3), 5));
//        System.out.println(new 路径总和().hasPathSum(TreeNode.geneTree(), 5));
//        System.out.println(new 路径总和().hasPathSum(TreeNode.geneTree(1, 2), 5));
//        System.out.println(new 路径总和().hasPathSum(TreeNode.geneTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22));
        System.out.println(hasPathSum1(TreeNode.geneTree(0, 4, 8, 11, null), 0));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
//        return pathsum(root,0,targetSum);
//        return pathsum1(root, targetSum);
        return pathsum2(root, targetSum);
    }

    public boolean pathsum(TreeNode root, int sum, int targetSum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        boolean lpathsum = false;
        boolean rpathsum = false;
        if (root.left != null) {
            lpathsum = pathsum(root.left, sum, targetSum);
        }
        if (root.right != null) {
            rpathsum = pathsum(root.right, sum, targetSum);
        }
        sum -= root.val;
        return lpathsum || rpathsum;
    }

    int cursum = 0;

    public boolean pathsum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        cursum += root.val;
        if (root.left == null && root.right == null) return cursum == targetSum;
        boolean left = pathsum1(root.left, targetSum);
        if (root.left != null) cursum -= root.left.val;
        boolean right = pathsum1(root.right, targetSum);
        if (root.right != null) cursum -= root.right.val;
        return left || right;
    }

    public boolean pathsum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return pathsum2(root.left, targetSum - root.val) || pathsum2(root.right, targetSum - root.val);
    }


    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == 0;
        targetSum -= root.val;
//            如果找到一个符合题目的,直接返回
        return  hasPathSum1(root.left, targetSum)||hasPathSum1(root.right, targetSum);
    }
}
