package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 10:19
 */
public class 左叶子之和 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left=treeNode1;
        treeNode.right=treeNode3;
        treeNode3.left=treeNode2;
        treeNode3.right=treeNode4;
        System.out.println(new 左叶子之和().sumOfLeftLeaves(treeNode));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return help(root);
    }
//    后序遍历
    int help(TreeNode root){
        if (root==null) return 0;
        int sum= help(root.left)+ help(root.right);
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            sum+= root.left.val;
        }
        return sum;
    }
}
