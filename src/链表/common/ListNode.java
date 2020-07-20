package 链表.common;

/**
 * 单链表
 */
public class ListNode {
    public Object data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
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
