package company.二叉树;

import company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-15 9:41
 */
public class 二叉树的所有路径 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        new 二叉树的所有路径().binaryTreePaths(treeNode);
        System.out.println();
    }

    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        help(root, new ArrayList<>());
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
}
