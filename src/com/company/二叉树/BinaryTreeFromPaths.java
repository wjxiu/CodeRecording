package com.company.二叉树;

import com.company.公共类.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BinaryTreeFromPaths {
    public TreeNode buildTreeFromPaths(List<List<Integer>> paths) { // 构建二叉树方法
        if (paths == null || paths.isEmpty()) { // 若路径列表为空，返回空树
            return null;
        }

        TreeNode root = new TreeNode(1); // 创建根节点，值为1
        for (List<Integer> path : paths) { // 遍历路径列表，添加每条路径到二叉树中
            addPathToTree(root, path);
        }

        return root; // 返回根节点
    }

    private void addPathToTree(TreeNode root, List<Integer> path) { // 将路径添加到二叉树方法
        for (int i = 1; i < path.size(); i++) { // 遍历路径中的节点值
            int val = path.get(i);
            if (root.left != null && root.left.val == val) { // 若当前节点的左子节点值与路径节点值相同，移动到左子节点
                root = root.left;
            } else if (root.right != null && root.right.val == val) { // 若当前节点的右子节点值与路径节点值相同，移动到右子节点
                root = root.right;
            } else { // 若当前节点没有匹配的子节点，则创建新的子节点，并移动到该子节点
                TreeNode newNode = new TreeNode(val);
                if (root.left == null) { // 如果当前节点的左子节点为空，将新节点作为左子节点
                    root.left = newNode;
                } else { // 否则将新节点作为右子节点
                    root.right = newNode;
                }
                root = newNode; // 移动到新创建的子节点
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> paths = new ArrayList<>(); // 创建路径列表
        paths.add(Arrays.asList(1, 2, 4, 89)); // 添加路径1
        paths.add(Arrays.asList(1, 2, 4, 10)); // 添加路径2
        paths.add(Arrays.asList(1, 2, 5, 11)); // 添加路径3
        paths.add(Arrays.asList(1, 2, 5, 12)); // 添加路径4
        paths.add(Arrays.asList(1, 3, 6, 13)); // 添加路径5
        paths.add(Arrays.asList(1, 3, 6, 14)); // 添加路径6
        paths.add(Arrays.asList(1, 3, 7)); // 添加路径7

        BinaryTreeFromPaths solution = new BinaryTreeFromPaths(); // 创建解决方案对象
        TreeNode root = solution.buildTreeFromPaths(paths); // 构建二叉树

        // 可以在这里对生成的二叉树进行遍历或其他操作
    }
}
