package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 10:19
 */
public class 左叶子之和 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.geneTree(3);
        System.out.println(new 左叶子之和().sumOfLeftLeaves1(treeNode));
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


    public int sumOfLeftLeaves1(TreeNode root) {
        if(root==null) return 0;
       int left= sumOfLeftLeaves1(root.left);
       int right= sumOfLeftLeaves1(root.right);
       int mid=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            mid= root.left.val;
        }
        return mid+left+right;
    }
}
