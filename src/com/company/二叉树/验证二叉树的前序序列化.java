package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.Stack;

/**
 * @author xiu
 * @create 2023-11-14 12:16
 */
public class 验证二叉树的前序序列化 {

    static boolean isValidSerialization(String preorder) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = preorder.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int res = 0;int j=i;
            if (Character.isDigit(c)) {
                while (Character.isDigit(c)&&j< charArray.length){
                    res=res*10+c-'0';
                    j++;
                    c=charArray[j];
                }
                i=j-1;
                stack.push((char)res);

            } else {
                if (stack.isEmpty()) return i == charArray.length - 1;
                else stack.pop();
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rob(TreeNode.geneTree(4, 1, null, 2, null, 3)));
    }
    static int rob(TreeNode root) {
        if(root==null)return 0;
        int[] help = help(root);
        return Math.max(help[0],help[1]);
    }
   static int[] help(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[] left= help(root.left);
        int[] right=help(root.right);
        int[] ints = new int[2];
        ints[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        ints[1]=left[0]+right[0]+root.val;
        return ints;
    }
}
