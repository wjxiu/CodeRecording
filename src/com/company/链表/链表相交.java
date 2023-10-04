package company.链表;
import company.公共类.ListNode;

/**
 * @author xiu
 * @create 2023-07-10 13:48
 */
public class 链表相交 {
    public static void main(String[] args) {
//        new 链表相交().getIntersectionNode1()
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa=headA;
        ListNode tempb=headB;
        while (tempa!=tempb){
            if (tempa==null){
                tempa=headB;
            }else{
                tempa=tempa.next;
            }
            if (tempb==null){
                tempb=headA;
            }else{
                tempb=tempb.next;
            }
        }
        return tempa;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        ListNode ta=headA;
        ListNode tb=headB;
        while (ta!=tb){
           ta= ta==null?headB:ta.next;
           tb= tb==null?headA:tb.next;
        }
        return ta;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        ListNode ta=headA;
        ListNode tb=headB;
        while (ta!=tb){
            ta=ta!=null?ta.next:headB;
            tb=tb!=null?tb.next:headA;
        }
        return ta;
    }
}
