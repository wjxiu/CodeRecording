package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-14 23:05
 */
public class 平衡二叉树 {
    public static void main(String[] args) {
        System.out.println(new 平衡二叉树().isBalanced(TreeNode.geneTree(3,9,20,null,null,15,7)));
        System.out.println(new 平衡二叉树().isBalanced(TreeNode.geneTree(1,2,2,3,3,null,null,4,4)));
    }
    public boolean isBalanced(TreeNode root) {
       return  getHeight1(root)!=-1;
    }
//    以当前传入节点为根节点的树的高度。
    private int getHeight(TreeNode root) {
        if (root==null) return 0;
        int left = getHeight(root.left);
        if (left==-1) return -1;
        int right = getHeight(root.right);
        if (right==-1) return -1;
        if (Math.abs(left-right)>1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }

    private int getHeight1(TreeNode root){
        if (root==null) return 0;
        int left = getHeight1(root.left);
        if (left==-1) return -1;
        int right = getHeight1(root.right);
        if (right==-1) return -1;
        if (Math.abs(left-right)>1) return -1;
        return  1+Math.max(left,right);
    }
}
