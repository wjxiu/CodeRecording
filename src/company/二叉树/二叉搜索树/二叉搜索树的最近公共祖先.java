package company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-16 11:16
 */
public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        System.out.println(new 二叉搜索树的最近公共祖先().lowestCommonAncestor1(TreeNode.geneTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)
                , new TreeNode(9), new TreeNode(4)));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)  {
        if (root==null||root.val==p.val||root.val==q.val) return root;
        int min=Math.min(p.val,q.val);
        int max=Math.max(p.val,q.val);
        if(root.val<min){
          return   lowestCommonAncestor(root.right,p,q);
        }else if(root.val>max){
          return   lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val>max){
             return  lowestCommonAncestor1(root.left, p, q);
        }else if(root.val<min){
             return  lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }
}
