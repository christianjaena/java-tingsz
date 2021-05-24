
import java.util.Arrays;


public class HackerEarth {
    private int capacity = 10;
    private int size = 0;
    
    private int[] items = new int[capacity];
    
    private int getLeftChildIndex(int index) { return (index * 2) + 1; }
    private int getRightChildIndex(int index) { return (index * 2) + 2; }
    private int getParentIndex(int index) { return (index * 2) / 2; }
    
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    
    private int getLeftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int getRightChild(int index) { return items[getRightChildIndex(index)]; }
    private int getParent(int index) { return items[getParentIndex(index)]; }
    
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    private void ensureCapacity() {
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
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[index] < getParent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
    
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getLeftChild(index) > getRightChild(index)) {
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
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HackerEarth he = new HackerEarth();
        he.add(10);
        he.add(15);
        he.add(20);
        he.add(17);
        he.add(25);
        he.print();
        he.poll();
        he.print();
    }
}
