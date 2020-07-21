package 链表.链表中环检测;

import 链表.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Action {
    public static boolean detectCircleSimple(ListNode head){
        //链表中节点可以多个指向一个，在分叉出两个节点指向一个节点，就能形成环
        //判断条件应该是只要进行循环，判断位置是否走过就行
        //足迹法
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        while (head.next!=null){
            if (set.contains(head.hashCode())){
                flag=true;
                break;
            }
            set.add(head.hashCode());
        }
        return flag;
    }

    public static boolean detectCirclePoint(ListNode head){
        //以上空间复杂度为 n ，时间复杂度为 O（n）
        //学习快慢指针
        boolean flag = false;
        ListNode quick=head.next,slow=head;
        while (quick!=null && quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
            if (quick==slow) {
                flag = true;
                break;
            }
        }
        return flag;
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
        ListNode node4 = new ListNode();
        node3.setNext(node4);
//        node4.setNext(node2);
        System.out.println("是否为环:"+detectCirclePoint(list));
    }
}
