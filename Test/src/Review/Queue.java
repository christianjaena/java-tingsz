
package Review;

import java.util.Arrays;


public class Queue {
    private int capacity = 1;
    private int size = 0;
    
    private int[] queue = new int[capacity];
    
    public void ensureCapacity() {
        if (size == capacity) {
            queue = Arrays.copyOf(queue, capacity * 2);
            capacity *= 2;
        }
    }
    
    public void enqueue(int value) {
        ensureCapacity();
        queue[size] = value;
        size++;
    }
    
    public void dequeue() {
        for (int i = 0; i < size; i++) {
            queue[i] = queue[i + 1];
            size--;
        }
    }
    
    public void print() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.print();
    }
}
