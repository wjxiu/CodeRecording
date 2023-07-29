package company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 15:10
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(new 验证二叉搜索树().isValidBST(TreeNode.geneTree(new Integer[]{-2147483648})));
    }
    //使用变量保存遍历过程中上一个的值
    long min=Long.MIN_VALUE;
    //必须是中序遍历，因为要根据bst的中序遍历是递增的性质来判断
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        boolean lvalidBST = isValidBST(root.left);
        if (root.val<=min){
            return false;
        }else{
            min=root.val;
        }
        boolean rvalidBST = isValidBST(root.right);
        return lvalidBST&&rvalidBST;
    }

}
