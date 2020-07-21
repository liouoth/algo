package 链表.两个有序的链表合并;

import 链表.common.ListNode;

public class Action {
    public ListNode<Integer> merge(ListNode<Integer> res,ListNode<Integer> target){
        if (res==null||target==null){
            return res==null?target:res;
        }
        ListNode<Integer> node = res;
        while (target.next!=null){
            if (node.getData()>target.getData()){

            }
        }
        return null;
    }
}
