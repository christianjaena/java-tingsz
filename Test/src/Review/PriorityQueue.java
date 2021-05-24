
package Review;


public class PriorityQueue {
    private int MAX;
    private int[] array;
    private int items;
    
    public PriorityQueue() {
        MAX = 10;
        array = new int[MAX];
        items = 0;
    }
    
    public void insert(int value) {
        int i;
        if (items == 0) {
            array[0] = value;
            items++;
            return;
        }
        for (i = items - 1; i >= 0; i--) {
            if (value > array[i]) {
                array[i + 1] = array[i];
            } else {
                break;
            }
        }
        array[i + 1] = value;
        items++;
    }
    
    public void print() {
        for (int i = 0; i < items; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
    
    public int remove() {
        return array[--items];
    }
    
    public boolean isFull() {
        return items == MAX;
    }
    
    public boolean isEmpty() {
        return items == 0;
    }
    
    public int peek() {
        return array[items - 1];
    }
    
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10);
        pq.insert(15);
        pq.insert(20);
        pq.insert(17);
        pq.insert(25);
        pq.print();
        pq.remove();
        pq.print();
    }
}
