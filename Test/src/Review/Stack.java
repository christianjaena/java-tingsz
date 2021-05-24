
package Review;

import java.util.Arrays;

public class Stack {
    private int capacity = 10;
    private int size = 0;
    
    private int[] stack = new int[capacity];
    
    public void ensureCapacity() {
        if (size == capacity) {
            stack = Arrays.copyOf(stack, capacity * 2);
            capacity *= 2;
        }
    }
    
    public void push(int value) {
        ensureCapacity();
        stack[size] = value;
        size++;
    }
    
    public void pop() {
        stack[size] = 0;
        size--;
    }
    
    public void peek() {
        System.out.println(stack[0]);
    }
    
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(stack[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.print();
        stack.peek();
    }
    
}
