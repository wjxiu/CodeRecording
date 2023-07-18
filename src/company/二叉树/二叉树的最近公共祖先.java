package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 21:43
 */
public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        new 二叉树的最近公共祖先().lowestCommonAncestor(TreeNode.geneTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}),new TreeNode(6),new TreeNode(7));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root.val==p.val||root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        如果两边都有,最终在回溯的公共祖先遇到，root就是祖先
        if (left!=null&&right!=null) return root;
//        如果有一边为null，那么这一边肯定不包含祖先，因为从退出条件来看，只有遇到是null才返回null
        if (left==null) return right;
        if (right==null) return left;
        return null;
    }
}
