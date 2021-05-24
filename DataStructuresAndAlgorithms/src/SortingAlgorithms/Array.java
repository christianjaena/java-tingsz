
package SortingAlgorithms;

import java.util.Arrays;


public class Array {
    
    private int[] theArray = new int[50];
    
    private int arraySize = 10;
    
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
    
    public boolean isThereAValue(int value){
        boolean foundValue = false;
        for (int i = 0; i < arraySize; i++) {
            if(value == theArray[i]){
                foundValue = true;
                System.out.println("Found in index " + i);
            }
            
        }
        if(foundValue == false){
            System.out.println("None");
        }
        return foundValue;
    }
    
    public void deleteIndex(int index){
        for (int i = index; i < (arraySize - 1); i++) {
            theArray[i] = theArray[i + 1];
        }
        arraySize--;
        printArray();
        
    }
    public void insertValue(int value){
       theArray[arraySize] = value;
       arraySize++;
       printArray();
    }
    
    public String linearSearch(int value){
        boolean valueInArray = false;
        String result = "";
        System.out.println("Value was found in indexs: ");
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value){
                valueInArray = true;
                System.out.print(i + " ");
                result += i  + " ";
                
            }   
        }
        
        if(!valueInArray){
            System.out.print("None");
            System.out.println(result);
        }
        return result;
    }
    
    public void bubbleSort(){
        for (int i = (arraySize - 1); i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(theArray[j] > theArray[j+1]){
                    swapValues(j, j+1);
                }
            }
        }
    }
    
    public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }
    
    public void binarySearch(int value){
        
        int lowIndex = 0;
        int highIndex = arraySize - 1;
        
        
        while(lowIndex <= highIndex){
            int middleIndex = (lowIndex + highIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
                
            else if (theArray[middleIndex] > value) highIndex = middleIndex - 1;
               
             else {
                System.out.print("\nFound Match " + value + " at index " + middleIndex);
                lowIndex = highIndex + 1; 
            }
        }
        
    }
    
    public void selectionSort(){
        for (int i = 0; i < arraySize; i++) {
            int minimum = i;
            
            for (int j = i; j < arraySize; j++) {
                if(theArray[minimum] > theArray[j])
                    minimum = j;
            }
            
            swapValues(i, minimum);
        }
    }
    
    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while((j > 0) && (theArray[j - 1]) > toInsert) {
                theArray[j] = theArray[j-1];
                j--;
            }
            theArray[j] = toInsert;
        }
    }
    

    public static void main(String[] args) {
        Array array = new Array();
        
        array.generateArray();
        array.printArray();
        array.insertionSort();
        System.out.println();
        array.printArray();
        
        
    }

}





    
