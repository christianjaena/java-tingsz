
package Review;

import java.util.Arrays;

public class Array {
    
    
    
    private int capacity = 10;
    private int size = 0;
    
    private int[] array = new int[capacity];
    
    public void ensureCapacity() {
        if (size == capacity) {
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
    }
    
    public void add(int value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }
    
    public void addFirst(int value) {
        ensureCapacity();
        size++;
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = value;
    }
    
    public void addTo(int index, int value) {
        ensureCapacity();
        size++;
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }
    
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Value: " + array[i]);
        }
        System.out.println();
    }
    
    public void removeLast() {
        array[size] = 0;
        size--;
    }
    
    public void removeFirst() {
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
    }
    
    public void removeAt(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
            size--;
        }
    }
    
    public void clear() {
        size = 0;
    }
    
    public void generateRandomArray() {
        for (int i = 0; i < size; i++) {
            array[i] = (int) ((Math.random() * 100) + 1);
        }
    }
    
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    public void swap(int first, int sec) {
        int temp = array[first];
        array[first] = array[sec];
        array[sec] = temp;
    }
    
    public void insertionSort() {
        for (int i = 0; i < size - 1; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        
    }
    
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size - 1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }
    
    public void quickSort() {
        quickSort(0, size - 1);
    }
    
    public void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(left, right, pivot);
        quickSort(left, index - 1);
        quickSort(index, right);
    }
    
    public int partition(int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    public void binarySearch(int value) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                System.out.println("Value found at index: " + mid);
                return;
            } else if (value < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    
    public void linearSearch(int value) {
        for (int i = 0; i < size; i++) {
            if (value == array[i]) {
                System.out.println("Value found at index: " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        Array arr = new Array();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.print();
//        arr.removeLast();
//        arr.print();
//        arr.removeFirst();
//        arr.print();
//        arr.removeAt(0);
//        arr.print();
//        arr.clear();
        //arr.print();
        arr.add(10);
        arr.add(15);
        arr.add(1);
        //arr.print();
        arr.addFirst(9);
        //arr.print();
        arr.addTo(2,17);
        //arr.print();
        //arr.generateRandomArray();
        arr.print();
        //arr.bubbleSort();
//        arr.linearSearch(10);
//        arr.print();
//        arr.binarySearch(12);
        arr.selectionSort();
        arr.print();
        
    }

}
