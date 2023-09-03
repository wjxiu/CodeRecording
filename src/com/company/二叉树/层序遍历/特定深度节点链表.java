package com.company.二叉树.层序遍历;

import company.公共类.TreeNode;
import company.公共类.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author xiu
 * @create 2023-09-03 7:50
 */
public class 特定深度节点链表 {
    public static void main(String[] args) {
        ListNode[] listNodes = new 特定深度节点链表().listOfDepth(TreeNode.geneTree(1, 2, 3, 4, 5, null, 7, 8));
        System.out.println(listNodes);
    }

    ArrayList<LinkedList<Integer>> path = new ArrayList<>();
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        bfs(tree);
        ListNode[] res = new ListNode[path.size()];
        for (int i = 0; i < path.size(); i++) {
            ListNode head = new ListNode();
            ListNode temp = head;
            LinkedList<Integer> integers = path.get(i);
            for (int j = 0; j < integers.size(); j++) {
                temp.next = new ListNode(integers.get(j));
                temp = temp.next;
            }
            res[i] = head.next;
        }
        return res;
    }

    private void bfs(TreeNode tree) {
        LinkedList<Integer> linked = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                linked.add(poll.val);
            }
            path.add(new LinkedList<>(linked));
            linked.clear();
        }

    }
}
