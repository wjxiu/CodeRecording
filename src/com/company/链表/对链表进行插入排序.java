package com.company.链表;

import com.company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-11-09 18:53
 */
public class 对链表进行插入排序 {
    static ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-9999);
        ListNode last=dummy;//排序后链表的最后一个元素
        while (head!=null){
            ListNode cur=dummy;//遍历排序后链表的变量
            ListNode pre= dummy;//cur的前面节点
            while(cur!=null&&cur.val<= head.val){
                pre=cur;
                cur=cur.next;
            }
            ListNode nexthead =head.next;
//            head比已经排序的元素都大
            if (cur==null){
                //更新last节点
                last.next=head;
                last=last.next;
//             这里记得要断开,不然会连到未排序的链表,这里的last就是head
                last.next=null;
            }else{
//                如果head插入位置在中间,在pre和cur之间插入
                pre.next=head;
                head.next=cur;
            }
            head= nexthead;
        }
        return dummy.next;
    }
}
