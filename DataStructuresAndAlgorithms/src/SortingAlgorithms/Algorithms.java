package SortingAlgorithms;


public class Algorithms {
    
    public int[] array = new int[50];
    private int arraySize = 10;
    

    public void printArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
    
    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) ((Math.random() * 10) + 1);
        }
    }
    
    public void generateSequencedArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = i;
        }
    }
    
    public void bubbleSort() {
        int lastSorted = array.length-1;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastSorted; i++) {
                if (array[i] > array[i + 1]) {
                    swapValues(i, i + 1);
                    isSorted = false;
                }
            }
            lastSorted--;
        }
        printArray();
    }
    
    public void bubbleSort2() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        printArray();
        }
    }
    
    public void bubbleSort3() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    swapValues(i,i + 1);
                }
            }
            printArray();
        }
    }
   
//    public void insertionSort() {
//        for (int i = 0; i < arraySize - 1; i++) {
//            int j = i;
//            int toInsert = array[i];
//            while (j > 0 && (array[j - 1] > toInsert)) {
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[j] = toInsert;
//        } 
//    }
    // 54321
    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int key = array[i];
            for (int j = i - 1; j >= 0 && key < array[j]; j--) {
                swapValues(i, j);
            }
        }
    }
    
    public void insertionS() {
        int i, j, key, temp;
        for (i = 1; i < arraySize; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && key < array[j]) {
                swapValues(j, j + 1);
                j--;
            }
        }
    }
    
    public void insertionSort2() {
        for (int i = 0; i < arraySize - 1; i++) {
            int toInsert = array[i];
            int j;
            for (j = i; j > 0 && (array[j - 1] > toInsert); j--) {
                array[j] = array[j - 1];
            } 
            array[j] = toInsert;
        }
    }
    
    public void swapValues(int first, int sec) {
        int temp = array[first];
        array[first] = array[sec];
        array[sec] = temp;
    }
    
    public void quickSort() {
        quickSort(0, array.length - 1);
    }
    
    public void quickSort(int left, int right) {
        if (left >= right){
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
    
    public void reverseArray() {
        int mid = (array.length) / 2;  
        int right = mid;     
        int left = mid - 1;
        while (right <= arraySize - 1 && left >= 0) {
           
            swapValues(right, left);
            right++;
            left--;
        }
    }
    
    public void removeDuplicates() {
        for (int i = 0; i < arraySize; i++) {
            int reference = array[i];
            for (int j = i + 1; j < arraySize; j++) {
                if (reference == array[j]) {
                    System.out.println("Found duplicate at: " + i + " and " + j);
                    for (int k = j; k < arraySize; k++) {
                        array[k] = array[k+1];
                    }
                    arraySize--;
                }
            }
        }
    }
    
    public void find2ndLargestNum() {
        int largest = array[0];
        int secLargest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                secLargest = largest;
                largest = array[i];
            } else if (array[i] > secLargest){
                secLargest = array[i];
            }
        }
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secLargest);
    }
    
    public static void main(String[] args) {
        Algorithms a = new Algorithms();
        
        a.generateRandomArray();
        a.printArray();
        a.insertionS();
        //a.printArray();
        //a.reverseArray();
        //a.removeDuplicates();
        //a.find2ndLargestNum();
        //a.insertionSort();
        //a.bubbleSort();
        a.printArray();
        
    }

}
