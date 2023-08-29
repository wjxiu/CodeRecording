package company.贪心;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-19 18:38
 */
public class 监控二叉树 {
    int res=0;
    public int minCameraCover(TreeNode root) {
        if (trival(root)==0) {
            res++;
        }
        return res;
    }
//    0：该节点无覆盖
//1：本节点有摄像头
//2：本节点有覆盖
    int trival(TreeNode root){
//     如果节点为空，认为覆盖
        if (root==null) return 2;
        int left = trival(root.left);
        int right = trival(root.right);
        if (left==2&&right==2) return 0;
        if (left==0|right==0){
            res++;
            return 1;
        }
        if (left==1||right==1) return 2;
        return -1;
    }
}
