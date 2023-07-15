package company.二叉树;

import company.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 14:51
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if (root1==null&&root2==null) return null;
        if (root1==null){
            return root2;
        }else if(root2==null){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left=mergeTrees(root1.left, root2.left);
        root.right=mergeTrees(root1.right,root2.right);
        return root;
    }
}
