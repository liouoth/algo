package 链表.链表中间节点检测;

import 链表.common.ListNode;

public class Action {
    //快慢指针，否则可以使用查找出总长度，然后在进行循环查找 复杂度为n
    public static ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first!=null&&first.next!=null){
            first = first.next.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode source = new ListNode();
        source.setData(1);
        ListNode node5 = new ListNode();
        node5.setData(5);
        source.setNext(node5);
        ListNode node6 = new ListNode();
        node6.setData(6);
        node5.setNext(node6);
        ListNode node9 = new ListNode();
        node9.setData(9);
        node6.setNext(node9);
        ListNode.stdOut(source);
        System.out.println(middleNode(source).data);
    }
}
