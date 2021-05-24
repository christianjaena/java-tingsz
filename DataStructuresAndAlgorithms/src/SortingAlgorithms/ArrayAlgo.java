
package SortingAlgorithms;

public class ArrayAlgo {
    
    private static int[] array;
    static long startTime;
    static long endTime;
    static int[] newArray = new int[100];
    
    ArrayAlgo(int size) {
        array = new int[size];
    }
    
    public void generateArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 20) + 1);
        }
    }
     
    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " -> " + array[i]);
        }
        System.out.println();
       
    }
    
    public void printNewArray() {
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(i + " -> " + newArray[i]);
        }
        System.out.println();
    }
    
    public boolean binarySearch(int value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                System.out.println("Value " + value + "found at index: " + mid);
                return true;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            }
        }
        return true;
    }
    
    public void selectionSort() {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length -1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if(min != i) {
                swapValues(i,min);
            }
        }
        
        endTime = System.currentTimeMillis();
    }
    
    public void selectionSort2() {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) min = j;
                swapValues(i,min);
            }
        }
        endTime = System.currentTimeMillis();
    }
    
    public void selectionSort3() {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swapValues(i, min);
            }
        }
        endTime = System.currentTimeMillis();
    }
    
    public void insertionSort() {
        startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int toInsert = array[i];
            while ((j > 0) && (array[j - 1]) > toInsert) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = toInsert;
        }
        endTime = System.currentTimeMillis();
    }
    
    public void insertionSort2() {
        startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        endTime = System.currentTimeMillis();
    }
    
    public void insertionSort3() {
        int j;
        int temp;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                for (j = i; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array [j];
                }
                array[j + 1] = temp;
            }
        }
        
    }
    
    public void swapValues(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    
    public void quickSort() {
        quickSort(0, array.length - 1);
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
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swapValues(left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
       ArrayAlgo test = new ArrayAlgo(15);
       test.generateArray();
       //System.arraycopy(array,0,newArray,newArray[newArray.length - 1],array.length);
       //test.printArray();
       //test.printNewArray();
       //test.selectionSort(); 
       //test.selectionSort2();
       //test.selectionSort3();
       //test.insertionSort2();
       test.quickSort();
       test.printArray();
       test.binarySearch(18);
       
    }

}
