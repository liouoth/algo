package 链表.单链表反转;

import 链表.common.ListNode;

public class Action {
    public static ListNode reserve(ListNode head){
        if (head==null){
            return null;
        }
        ListNode tail = head;
        while (head.next!=null){
            ListNode temp = head.next.next;
            head.next.next = tail;
            tail = head.next;
            head.next = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.setData(1);
        ListNode node1 = new ListNode();
        node1.setData(2);
        list.setNext(node1);
        ListNode node2 = new ListNode();
        node2.setData(3);
        node1.setNext(node2);
        ListNode node3 = new ListNode();
        node3.setData(4);
        node2.setNext(node3);
        System.out.println("逆置前:");
        ListNode.stdOut(list);
        list = reserve(list);
        System.out.println("逆置后:");
        ListNode.stdOut(list);
    }
}
