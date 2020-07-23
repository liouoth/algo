package 链表.删除链表倒数第n个结点;

import 链表.common.ListNode;

/**
 * 链表倒数第n个节点
 * 笨方法循环得到长度，再长度-n，再循环一次，删除
 */
public class Action {
    public static ListNode deleteN(ListNode list,int n){
        if (list==null){
            return list;
        }
        ListNode loop = list;

        int length = 1;

        for (;loop.next!=null;length++){
            loop = loop.next;
        }

        if (length<n){
            return list;
        }

        ListNode node = list;
        for (int j = 1;j<=length-n;j++){
            if (j==length-n){
                ListNode temp = node.next.next;
                node.next.next = null;
                node.next = temp;
            }
            node = node.next;
        }
        return list;
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
        System.out.println("删除前：");
        ListNode.stdOut(source);
        deleteN(source,1);
        System.out.println("删除倒数第一个节点：");
        ListNode.stdOut(source);
    }
}
