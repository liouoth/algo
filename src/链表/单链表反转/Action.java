package 链表.单链表反转;

import 链表.common.ListNode;

/**
 *  @name Action
 *  @Description 单链表反转
 *  @author will7 Mao
 *  @Date  2020/7/21
 */
public class Action {
    public static ListNode reserve(ListNode head){
        //需要对head做判空操作，因为需要判断head.next
        //如果head.next为空则返回head,只有一个节点返回本身不需要反转
        if (head==null||head.next==null){
            return head;
        }

        ListNode tail = head;
        /**
         * 想法一个节点不能指向多个，但是可以多个节点都指向一个
         * 首先1-》2-》3 ,变成 1<-2-<3
         * head是头节点，tail是逆置后的头节点
         * 因为改变 2 的 后继节点会让 3丢失，所以先保存3的引用为temp
         * 先让head的后继节点，指向逆置后的头节点 tail，初始tail指向head，接着是tail是2，3，最后是4
         * 然后将tail指向head之后的元素
         * 最后将head指向temp引用
         */
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
