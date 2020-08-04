package 队列;


import java.util.Arrays;

public class Queue<T> {
    private T [] array;
    private int head;
    private int tail;
    private int size;

    public Queue(int capacity) {
        array = (T[]) new Object[capacity];
        size = capacity;
        head=0;
        tail=0;
    }

    public boolean enQueue(T t){
        //有一点我其实很不清楚，就是tail。tail满的状态是 tail == size 也就是tail指向的是空的地方，比实际的元素index大1
        //tail==size
        if (tail==size){
            //表示已经满了
            if (head==0)return false;
            //未满，数据搬迁
            int i =0;
            for (;head<=tail;head++){
                array[i] = array[tail];
            }
            head=0;
            tail=i;
        }
        array[tail++]=t;
        return true;
    }

    public T deQueue(){
        if (head==tail)return null;
        T temp = array[head];
        head++;
        return temp;
    }

    @Override
    public String toString() {
        return "Queue:" + Arrays.toString(Arrays.copyOfRange(array,head,tail));
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(2);
        queue.enQueue(1);
        System.out.println(queue);
        queue.enQueue(2);
        System.out.println(queue);
        System.out.println(queue.enQueue(3));
        System.out.println(queue);
        queue.deQueue();
        System.out.println(queue);
    }
}
