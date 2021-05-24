
package SortingAlgorithms;


public class QuickSort2 {
    
    public static int[] array;
    
    QuickSort2(int size) {
        array = new int[size];
    }
    
    void generateArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 20) + 1);
        }
    }
    
    void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " -> " + array[i]);
        }
        System.out.println();
    }
    
    void quickSort() {
        quickSort(0, array.length - 1);
    }
    
    void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(left, right, pivot);
        quickSort(left, index - 1);
        quickSort(index, right);
    }
    
    int partition(int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    void swap(int first, int sec) {
        int temp = array[first];
        array[first] = array[sec];
        array[sec] = temp;
    }
    public static void main(String[] args) {
        QuickSort2 q = new QuickSort2(10);
        q.generateArray();
        q.printArray();
        q.quickSort();
        q.printArray();
    }
}
