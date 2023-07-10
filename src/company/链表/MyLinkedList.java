package company.链表;

/**
 * @author xiu
 * @create 2023-07-10 10:08
 */
public class MyLinkedList {
//    没写出来
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        System.out.println();
    }
    int size;
    ListNode dummy;

    public MyLinkedList() {
        size=0;
        dummy=new ListNode();
    }

    public int get(int index) {
        int count=-1;
        ListNode temp=dummy;
        while (temp!=null){
            count++;
            if (index==count){
                return temp.val;
            }
            temp=temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index>size||index<0)return ;
        ListNode temp=dummy;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        size++;
        ListNode listNode = new ListNode(val);
        listNode.next=temp.next;
        temp.next= listNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode temp=dummy;
        for (int i = 0; i < index; i++) {
                temp=temp.next;
        }
        temp.next=temp.next.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val=val;
    }
}