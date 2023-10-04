package com.company.链表;

import com.company.公共类.ListNode;

import java.util.HashSet;

/**
 * @author xiu
 * @create 2023-08-30 21:34
 */
public class 移除重复节点 {
    public static void main(String[] args) {
        System.out.println(new 移除重复节点().removeDuplicateNodes(ListNode.geneList(1, 2, 3, 3, 2, 1)));
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp1 = cur;
            if (set.contains(cur.val)) pre.next = cur.next;
            else pre = cur;
            cur = cur.next;
            set.add(temp1.val);
        }
        return dummy.next;
    }
}
