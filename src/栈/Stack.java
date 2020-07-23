package 栈;

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

    public String pop(){
        return null;
    }
}
