package 链表.两个有序的链表合并;

import 链表.common.ListNode;

public class Action {
    public static ListNode<Integer> merge(ListNode<Integer> source,ListNode<Integer> target){
        //两个链表：source 和 target，将target的节点合并到source中
        if (target==null){
            return source;
        }

        //哨兵
        ListNode<Integer> head = new ListNode<>();
        head.setNext(source);

        ListNode<Integer> tail = head;

        while (target!=null){
            if (tail.next==null){
                ListNode<Integer> temp = target.next;
                tail.next = target;
                target.next = null;
                target = temp;
                tail = tail.next;
                continue;
            }

            if (tail.next.getData()>target.getData()){
                ListNode<Integer> temp = tail.next;
                tail.next = target;
                target = tail.next.next;
                tail.next.next = temp;
            }else {
                tail = tail.next;
            }
        }
        return head.next;
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

        System.out.println("source:");
        ListNode.stdOut(source);

        ListNode target = new ListNode();
        target.setData(2);
        ListNode node3 = new ListNode();
        node3.setData(3);
        target.setNext(node3);
        ListNode node4 = new ListNode();
        node4.setData(4);
        node3.setNext(node4);
        ListNode node7 = new ListNode();
        node7.setData(7);
        node4.setNext(node7);

        System.out.println("target:");
        ListNode.stdOut(target);

        System.out.println("合并后：");
        ListNode.stdOut(merge(null,target));
    }
}
