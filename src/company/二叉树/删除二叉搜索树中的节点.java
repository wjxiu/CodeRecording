package company.二叉树;

import company.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 12:28
 */
public class 删除二叉搜索树中的节点 {
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
}
