package com.company.公共类;

/**
 * @author xiu
 * @create 2023-07-09 16:54
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode geneList(int... nodes){
        ListNode listNode = new ListNode(-1);
        ListNode temp=listNode;
        for (int node : nodes) {
            temp.next = new ListNode(node);
            temp = temp.next;
        }
        return listNode.next;
    }

    @Override
    public String toString() {
//        return this.val+"";
        ListNode listNode = this;
        StringBuilder sb = new StringBuilder();
        while (listNode!=null){
            sb.append(listNode.val).append("->");
            listNode=listNode.next;
        }
        return sb.substring(0,sb.length()-2);
    }

}