package company.二叉树;

import company.TreeNode;

/**
 * @author xiu
 * @create 2023-07-14 23:05
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
       return  getHeight(root)!=-1;
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
}
