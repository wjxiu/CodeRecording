package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 12:28
 */
public class 删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        System.out.println(new 删除二叉搜索树中的节点().deleteNode1(TreeNode.geneTree(5, 3, 6, 2, 4, null, 7), 3));
    }
    //deleteNode(root,key)返回的是删除root.val=key后的树的根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
//            相当于下面注释的代码
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode temp1 = root.right;
            while (temp1.left != null) temp1 = temp1.left;
            temp1.left = root.left;
            return root.right;

//            if (root.left==null&&root.right==null){
//                root=null;
//                return root;
//            }else if(root.left==null&&root.right!=null){
//                return root.right;
//            }else if(root.left!=null&&root.right==null){
//                return root.left;
//            }else{
//                TreeNode temp1=root.right;
//                while (temp1.left!=null) temp1=temp1.left;
//                temp1.left=root.left;
//                return root.right;
//            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
//            第三种情况,找右子树最左边
                TreeNode tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                tmp.left = root.left;
                TreeNode temp1= root.right;
                root=null;
                return temp1;
            }
        }
        if (key < root.val) root.left=deleteNode1(root.left, key);
        else root.right=deleteNode1(root.right, key);
        return root;
    }

}
