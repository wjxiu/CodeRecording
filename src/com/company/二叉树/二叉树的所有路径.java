package company.二叉树;

import company.公共类.TreeNode;

import java.util.*;

/**
 * @author xiu
 * @create 2023-07-15 9:41
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {
        List<String> strings = new 二叉树的所有路径().binaryTreePaths(TreeNode.geneTree(1, 2, 3, 4, 5, 6, 7, 89, 10, 11, 12, 13, 14));
    }

    List<String> list = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        help1(root);
        System.out.println(list);
        return list;
    }

    void help(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : path) sb.append(integer).append("->");
            String substring = sb.substring(0, sb.length() - 2);
            list.add(substring);
            path.remove(path.size() - 1);
        }
        path.add(root.val);
        if (root.left != null) help(root.left, path);
        if (root.right != null) help(root.right, path);
//        回溯，这行放在两个if还是单独抽出来都可以
        path.remove(path.size() - 1);
    }


    void help1(TreeNode root) {
        if (root.left==null&&root.right==null){
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            path.forEach(p-> sb.append(p).append("->"));
            list.add(sb.substring(0,sb.length()-2));
            return;
        }
        path.add(root.val);
        if (root.left!=null)help1(root.left);
        path.remove(path.size()-1);
        if (root.right!=null)help1(root.right);
        path.remove(path.size()-1);


    }

}
