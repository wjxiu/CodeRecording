package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-07-15 10:38
 */
public class 找树左下角的值 {

    int res = -1;
    int maxdepth = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        help1(root, 0);
        return res;
    }

    public void help(TreeNode root, int depth) {
        if (root == null) return;
        if (maxdepth > depth) {
            res = root.val;
            maxdepth = depth;
        }
        if (root.left != null) {
            help(root.left, depth + 1);
        }
        if (root.right != null) {
            help(root.right, depth + 1);
        }
    }

    public void help1(TreeNode root, int depth){
        if (root==null) return;
        if (depth>maxdepth){
            res=root.val;
            maxdepth=depth;
        }
        help1(root.left,depth+1);
        help1(root.right,depth+1);
//        depth-=1;
    }
    static int findBottomLeftValue1(TreeNode root) {
        int res=0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                if (i==0)res= pop.val;
                if (pop.left!=null)queue.offer(pop.left);
                if (pop.right!=null)queue.offer(pop.right);
            }
        }
        return res;
    }
}
