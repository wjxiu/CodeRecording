package company.二叉树;

import company.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 10:47
 */
public class 路径总和 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.geneTree(new Integer[]{1,2});
        System.out.println(new 路径总和().hasPathSum(root, 0));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        return pathsum(root,0,targetSum);
    }
    public boolean pathsum(TreeNode root, int sum,int targetSum){
        sum += root.val;
        if (root.left==null&&root.right==null){
            return sum==targetSum;
        }
        boolean lpathsum=false;
        boolean rpathsum=false;
        if (root.left!=null){
             lpathsum = pathsum(root.left,sum , targetSum);
        }
        if (root.right!=null){
             rpathsum = pathsum(root.right, sum, targetSum);
        }
        sum-=root.val;
        return lpathsum||rpathsum;
    }
}
