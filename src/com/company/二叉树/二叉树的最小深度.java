package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-28 14:53
 */
public class 二叉树的最小深度 {
    public static void main(String[] args) {
        System.out.println(new 二叉树的最小深度().minDepth(TreeNode.geneTree(3, 9, 20, null, null, 15, 7)));
        System.out.println(new 二叉树的最小深度().minDepth(TreeNode.geneTree(2)));
    }

    //    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right != null) {
            int left = minDepth(root.right);
            int right = minDepth(root.left);
            return 1 + Math.min(left, right);
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + minDepth(root.left);
        }
    }
}
