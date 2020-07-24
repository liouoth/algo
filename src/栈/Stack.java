package 栈;

import java.util.Arrays;
import java.util.Objects;

public class Stack<T> {
    private T [] container;
    private int top;
    private int length;

    public Stack(int capacity) {
        this.length = capacity;
        container = (T[]) new Object [capacity];
        top = 0;
    }

    public T pop(){
        if (container==null||top==0){
            return null;
        }
        top--;
        return container[top-1];
    }

    public void push(T newOne){
        if (top==length){
            container = Arrays.copyOf(container,2*length);
            length = 2*length;
        }
        container[top] = newOne;
        top++;
    }

    public static void main(String[] args) {
        Stack<String> test = new Stack<>(2);
        test.push("1234");
        test.push("1");
        System.out.println(test.length);
        test.push("1");
        System.out.println(test.length);
        test.push("1");
        System.out.println(test.length);
        System.out.println(test.top);
        System.out.println(Arrays.toString(test.container));
        test.pop();
        System.out.println(Arrays.toString(test.container)+"top:"+test.top);
    }

}
