package com.company.链表;
import com.company.公共类.ListNode;

/**
 * 题目意思是是删除指定节点，形参是待删除的节点，不是链表头
 * @author xiu
 * @create 2023-08-31 10:18
 */
public class 删除中间节点 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.geneList(1, 2, 2, 3, 4, 4, 4, 4, 5);
    }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
