
package SortingAlgorithms;

import java.util.Arrays;


public class QuickSort {
    
    private static int[] theArray;
    private int arraySize;
    
    QuickSort(int newArraySize){
        arraySize = newArraySize;
        theArray = new int[arraySize];
        generateArray();
    }
    
    public void generateArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }
    
    public void printArray(){
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + " -> " + theArray[i]);
        }
    }  
    
    public void partitionArray(int pivot){
        int leftPointer = -1;
        int rightPointer = arraySize;
        
        while(true){
            while(leftPointer < (arraySize -1) && theArray[++leftPointer]< pivot)
                ;
            printArray();
            System.out.println(theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value " + pivot);
            while(rightPointer > 0 && theArray[--rightPointer] >pivot)
                ;
            printArray();
            System.out.println(theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value " + pivot);
            printArray();
            if(leftPointer >= rightPointer) break;
            else{
                swapValues(leftPointer, rightPointer);
                System.out.println(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);
            }
        }
    }
    
    public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }
    
    public static void main(String[] args){
        QuickSort qs = new QuickSort(10);
        qs.generateArray();
        System.out.println(Arrays.toString(QuickSort.theArray));
        qs.partitionArray(35);
        System.out.println(Arrays.toString(QuickSort.theArray));
    }

}
