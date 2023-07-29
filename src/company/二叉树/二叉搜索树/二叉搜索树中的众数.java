package company.二叉树.二叉搜索树;

import company.公共类.TreeNode;

import java.util.ArrayList;

/**
 * @author xiu
 * @create 2023-07-15 21:27
 */
public class 二叉搜索树中的众数 {
    Integer pre=null;
    ArrayList<Integer> list=new ArrayList<>();
    int maxcount=0;
    public int[] findMode(TreeNode root) {
        help(root);
        int[] ints = list.stream().mapToInt(i -> i).toArray();
        return ints;
    }
    int count=0;
    void help(TreeNode root){
        if (root==null) return;
        help(root.left);
        if (pre==null){
            count=1;
        }else if (pre==root.val){
            count++;
        }else{
            count=1;
        }
        if (count==maxcount){
            list.add(root.val);
        }
        if (count>maxcount){
            maxcount=count;
            list.clear();
            list.add(root.val);
        }
        pre=root.val;
        help(root.right);
    }
}
