package company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 15:10
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(new 验证二叉搜索树().isValidBST2(TreeNode.geneTree(2,1,3)));
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

//这里是long
    long min1=Integer.MIN_VALUE;
    public boolean isValidBST1(TreeNode root){
        if (root==null) return true;
       boolean left= isValidBST1(root.left);
//       严格大于
        if (min1< root.val){
            min1= root.val;
        }else{
            return false;
        }
        boolean right= isValidBST1(root.right);
        return left&&right;
    }

    public boolean isValidBST2(TreeNode root){
        return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean help(TreeNode root,Long lower,Long upper){
        if (root==null) return true;
        if (root.val<=lower||root.val>=upper) return false;
        return help(root.left,lower,Long.parseLong(root.val+""))&&
         help(root.right,Long.parseLong(root.val+""),upper);
    }
}
