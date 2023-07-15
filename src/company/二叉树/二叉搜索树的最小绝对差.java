package company.二叉树;

import company.TreeNode;

import java.util.ArrayList;

/**
 * @author xiu
 * @create 2023-07-15 21:00
 */
public class 二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.geneTree(new Integer[]{4, 2, 6, 1, 3});
        new 二叉搜索树的最小绝对差().help1(root);
    }

    ArrayList<Integer> list = new ArrayList<Integer>();
    int res = Integer.MAX_VALUE;

    //    转成有序数组
    public int getMinimumDifference(TreeNode root) {
        help(root);
        res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int i1 = list.get(i) - list.get(i - 1);
            res = Math.min(res, i1);
        }
        return res;
    }

    void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        list.add(root.val);
        help(root.right);
    }

    TreeNode pre = new TreeNode();

    //    递归，和上面思路一致，但是没有数组保存所有值，保存遍历过程的上一个值
    void help1(TreeNode root) {
        if (root==null) return;
        help1(root.left);
        if (pre.val!=null){
            res = Math.min(res, root.val - pre.val);
        }
        pre=root;
        help1(root.right);
    }
}
