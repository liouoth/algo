package 链表.实现缓存;

import 链表.common.ListNode;

//使用链表实现LRU缓存
public class Lru {
    private static ListNode<Integer> head;
    private static Integer max_size = 5;

    public static  Integer put(Integer tmp){
        if (head==null){
            head = new ListNode<Integer>(tmp,null);
            return tmp;
        }
        //判断缓存中是否存在
        ListNode exist = null;
        if ((exist=isExist(tmp))!=null){
            move(exist);
            return tmp;
        }

        //不存在，则判断，缓存是不是满了
        //满了，则将尾部移除，加在头部
        //未满则加在头部
        ListNode<Integer> node = new ListNode<>();
        node.data = tmp;
        if (count()>=max_size){
            pop();
        }
        node.next = head;
        head = node;
        return tmp;
    }

    private static void move(ListNode exist) {
        if (exist==head)return;

        ListNode tempHead = head;
        while (tempHead!=null){
            if (tempHead.next==exist){
                break;
            }
            tempHead = tempHead.next;
        }
        tempHead.next = exist.next;
        exist.next = head;
        head = exist;
    }

    public static ListNode isExist(Integer tmp){
        ListNode node = head;
        while (node!=null){
            if (node.data==tmp){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static void pop(){
        ListNode<Integer> tail = head;
        ListNode<Integer> tailHead = null;
        while (tail.next!=null){
            if (tail.next.next==null){
                tailHead = tail;
            }
            tail = tail.next;
        }
        tail = null;
        tailHead.next = null;
    }

    public static Integer count(){
        Integer count = 0;
        ListNode node = head;
        while (node!=null){
            count++;
            node = node.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Lru.put(1);
        Lru.put(2);
        Lru.put(3);
        Lru.put(4);
        Lru.put(5);
        ListNode.stdOut(Lru.head);
        Lru.put(6);
        ListNode.stdOut(Lru.head);
        Lru.put(6);
        Lru.put(5);
        ListNode.stdOut(Lru.head);
        Lru.put(4);
        ListNode.stdOut(Lru.head);
        Lru.put(2);
        ListNode.stdOut(Lru.head);
    }
}
