package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-28 13:35
 */
public class 二叉树的最大深度 {
    public static void main(String[] args) {
        System.out.println(new 二叉树的最大深度().maxDepth(TreeNode.geneTree(3, 9, 20, null, null, 15, 7)));
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.min(maxDepth(root.left),maxDepth(root.right));
    }
}
