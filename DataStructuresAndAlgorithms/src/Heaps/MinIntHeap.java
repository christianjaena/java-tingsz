package Heaps;


import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MinIntHeap {
    static PrintWriter pw = new PrintWriter(System.out);
    private int capacity = 10;
    private int size = 0;
    
    int[] items = new int[capacity];
    
    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
    
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    
    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }
    
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }
    
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }
    
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) <  leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex; 
        }
    }
    
    public void print() {
        pw.println("------------------------------------");
        pw.println("Number of patients in the queue: " + size);
        pw.print("Priority Queue: [");
        for (int i = 0; i < size; i++) {
            if (i > 0) { pw.print(","); }
            pw.print(items[i]);   
        }
        pw.println("]");
    }
    
    public static void main(String[] args) throws Exception {
        MinIntHeap mh = new MinIntHeap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        java.util.Scanner input = new java.util.Scanner(System.in);
        pw.println("1 - Emergency Cases i.g. (life-threatening cases like a bullet wound, vehicular accident, stoke etc)\n" + "2 - Child Birth\n" + "3 - Senior Citizen, PWD\n" + "4 - Children\n" + "5 - Others");
        pw.println();
        pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
        while (true) {
            pw.flush();
            try {
                int person = Integer.parseInt(br.readLine());
                if (person == 0) { 
                    if (mh.size <= 0) {
                        pw.println();
                        pw.println("There are no patients in the queue.");
                        pw.println();
                        pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
                    } else {
                        mh.poll();
                        mh.print();
                        if (mh.size != 0) {
                            pw.println("Top of the Queue: " + mh.peek());
                            pw.println("------------------------------------");
                            pw.println();
                            pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
                        } else {
                            pw.println("The queue is empty.");
                            pw.println("------------------------------------");
                            pw.println();
                            pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
                        }
                    }
                } else if (person > 5 || person < -1) {
                    pw.println();
                    pw.println("Enter 1-5 only.");
                    pw.println();
                    pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
                } else if (person == -1) {
                    break;
                } else {
                    mh.add(person);
                    mh.print();
                    pw.println("Top of the Queue: " + mh.peek());
                    pw.println("------------------------------------");
                    pw.println();
                    pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entered value is not an integer");
                pw.print("Enter 1-5 to enqueue, 0 to dequeue, -1 to quit: ");
            }
        }
        pw.close();
   }
}
