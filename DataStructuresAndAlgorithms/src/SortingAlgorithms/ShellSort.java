
package SortingAlgorithms;

import java.util.Arrays;

public class ShellSort {
    private int[] theArray;
    
    private int arraySize;
    
    public void generateArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }
    
    public static void main(String[] args){
        ShellSort sh = new ShellSort(10);
        System.out.println(Arrays.toString(sh.theArray));
        sh.sort();
        System.out.println(Arrays.toString(sh.theArray));
    }
    
    public void sort(){
        int inner, outer, temp;
        int interval = 1;
        
        while(interval <= arraySize / 3){
            interval = interval * 3 + 1;
            
            while(interval > 0){
                for (outer = interval; outer < arraySize; outer++) {
                     temp = theArray[outer];
                     System.out.println("Copy " + theArray[outer] + " into temp");
                     inner = outer;
                     System.out.println("Checking if"
                        + theArray[inner - interval] + " in index "
                        + (inner - interval) + " is bigger than " + temp);
                     while(inner > interval - 1 && theArray[inner - interval] >= temp ){
                         System.out.println("In while checking if " + theArray[inner - interval] +
                                 " in index " + (inner - interval) + " is bigger than " + temp);
                         printArray();
                         
                         theArray[inner] = theArray[inner - interval];
                         System.out.println(theArray[inner-interval] + " moved to index" + inner);
                         inner -= interval;
                         System.out.println("inner = " + inner);
                         printArray();
                         
                         System.out.println("outer = " + outer);
                         System.out.println("temp = " + temp);
                         System.out.println("interval = " + interval);
                     }
                     
                     theArray[inner] = temp;
                     System.out.println(temp + " moved to index " + inner );
                     printArray();
                }
                interval = (interval - 1)/3;
            }
        }
    }
     public void printArray(){
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + " -> " + theArray[i]);
        }
    }  
    
    ShellSort(int arraySize){
        this.arraySize = arraySize;
        theArray = new int[arraySize];
        generateArray();
    }
}
