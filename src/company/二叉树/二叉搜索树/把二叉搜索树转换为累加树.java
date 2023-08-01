package company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 15:41
 */
public class 把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        System.out.println(new 把二叉搜索树转换为累加树().convertBST(TreeNode.geneTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)));
    }
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        build1(root);
        return root;
    }
    int build(TreeNode root){
        if (root==null) return 0;
        build(root.right);
        sum+=root.val;
        root.val=sum;
        build(root.left);
        return sum;
    }
    
    
    int build1(TreeNode root){
        if (root==null) return 0;
         build1(root.right);
        root.val+=sum;
        sum=root.val;
        build1(root.left);
        return sum;
    }

}
