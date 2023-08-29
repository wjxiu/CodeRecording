package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 14:51
 */
public class 合并二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.geneTree(1, 3, 2, 5);
        TreeNode treeNode = TreeNode.geneTree(2, 1, 3, null, 4, null, 7);
        System.out.println(new 合并二叉树().mergeTrees1(treeNode1, treeNode));
    }
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


    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2){
        if (root1==null&&root2==null) return null;
        if (root1==null){
            return root2;
        }
        if (root2==null) return root1;
        TreeNode treeNode = new TreeNode(root2.val + root1.val);
        treeNode.left=mergeTrees1(root1.left, root2.left);
        treeNode.right=mergeTrees1(root1.right, root2.right);
        return treeNode;
    }
}
