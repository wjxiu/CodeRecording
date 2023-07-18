package company.二叉树;

import company.公共类.TreeNode;

import java.util.HashMap;

/**
 * @author xiu
 * @create 2023-07-15 13:13
 */
public class 中序与后序遍历序列构造二叉树 {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length-1,0, postorder.length-1 );
    }

    TreeNode build(int instart, int inend, int poststart, int postend) {
        //        1.递归出口:数组为空
        if (instart>inend){
            return null;
        }
//        2.取后序最后一个节点
        int lastval = postorder[postend];
        TreeNode root = new TreeNode(lastval);
        //中序根节点索引
        int lastindex=valToIndex.get(lastval);
//        3.切中序 左闭右闭
        int ileftend=lastindex-1;
        int irightstart=lastindex+1;
//        4.切后序 左闭右闭
        int pleftend=ileftend-instart+1;
        int prightstart=postend+1-poststart+pleftend;
//        5.递归处理左右区间
//        左区间
        TreeNode left = build(instart, ileftend, lastindex + 1, postend);
//        右区间
        TreeNode right = build(irightstart, inend, prightstart, lastindex - 1);
        root.left=left;
        root.right=right;
        return root;
    }
}
