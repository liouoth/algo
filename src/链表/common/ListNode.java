package 链表.common;

/**
 * 单链表
 */
public class ListNode <T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public static void stdOut(ListNode head) {
        if (head==null){
            System.out.println("链表:[]");
        }
        StringBuffer stringBuffer = new StringBuffer("链表：[").append(head.data);
        ListNode node = head;
        while (node.next!=null){
            stringBuffer.append("->");
            stringBuffer.append(node.next.getData());
            node = node.next;
        }
        System.out.println(stringBuffer.append("]").toString());
    }
}
