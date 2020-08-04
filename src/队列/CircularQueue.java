package 队列;


import java.util.Arrays;

/**
 * 相对比普通队列，循环队列可以省去数据搬移的操作
 * 普通队列：队满条件，tail=size 队空条件，tail=head
 * 循环队列：队空条件，tail=head 队满条件 tail+1%size = head
 * 因为为了区别于队空的情况，循环队列需要留一个位置为空，作为队空 队满的区别
 */
public class CircularQueue<T> {
    private T [] array;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int capacity) {
        array = (T[]) new Object[capacity];
        size = capacity;
        head=0;
        tail=0;
    }

    public boolean enQueue(T t){
        if ((tail+1)%size==head)return false;
        array[tail]=t;
        tail = (tail+1)%size;
        return true;
    }

    public T deQueue(){
        if (head==tail)return null;
        T temp = array[head];
        head = (head+1)%size;
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("Queue[");
        for (int i=head;i%size!=tail;i++){
            s.append(array[i%size]);
            if (i%size+1!=tail){
                s.append(",");
            }
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.enQueue(4));
        System.out.println(queue.toString());
        queue.deQueue();
        System.out.println(queue.toString());
        queue.deQueue();
        System.out.println(queue.toString());
        queue.deQueue();
        System.out.println(queue.toString());
        queue.deQueue();
        System.out.println(queue.toString());
        System.out.println(queue.deQueue());
        System.out.println("tail"+queue.tail);
        System.out.println("head"+queue.head);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println("tail"+queue.tail);
        System.out.println("head"+queue.head);
        System.out.println(queue.toString());
        System.out.println(queue.enQueue(5));
    }
}
