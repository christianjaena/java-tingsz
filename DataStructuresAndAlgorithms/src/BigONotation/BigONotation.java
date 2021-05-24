
package BigONotation;


public class BigONotation {
    
    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;
    
    // O(1)
    public void addItemToArray(int newItem){
        theArray[++itemsInArray] = newItem;
    }
    
    // O(N)
    
    public void linearSearchForValue(int value){
        
        boolean valueInArray = false;
        String indexsWithValue = "";
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == value){
                valueInArray = true;
                indexsWithValue += i + " ";
            }
        }
        
        System.out.println("Value Found: " + valueInArray);
        endTime = System.currentTimeMillis();
        System.out.println("Linear Search Took: " + (endTime - startTime));
    }
    
    // O(N^2)
    
    public void bubbleSort(){
        startTime = System.currentTimeMillis();
        
        for (int i = arraySize-1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(theArray[j] > theArray[j+1]){
                    swapValues(j, j+1);
                }
            }
            
        }

        endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Took: " + (endTime - startTime));
        
    }
    
    // O(log N)
    
    public void binarySearchForValues(int value){
        startTime = System.currentTimeMillis();
        
        int lowIndex = 0;
        int highIndex = arraySize - 1;
        
        int timesThrough = 0;
        
        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else{
                System.out.println("Found Match in index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            timesThrough++;
        }
        
        endTime = System.currentTimeMillis(); 
        System.out.println("Bubble Sort Took: " + (endTime - startTime));
        System.out.println("Times Through " + timesThrough);
    }
    
    // O(n log n)
    
    public void quickSort(int left, int right){
        if(right - left <= 0) return;
        
        else{
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left,pivotLocation -1);
            quickSort(pivotLocation + 1, right);
        }
        
    }
    
    public int partitionArray(int left, int right, int pivot){
        int leftPointer = left - 1;
        int rightPointer = right;
        
        while(true){
            while(theArray[++leftPointer] < pivot)
                ;
            while(rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;
            if(leftPointer >= rightPointer){
                break;
            }else{
                swapValues(leftPointer, rightPointer);
            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }
    
     public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }
    
     public void generateArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 1000) + 10;
        }
        itemsInArray = arraySize - 1;
    }
    
     BigONotation(int size){
         arraySize = size;
         theArray = new int[size];
     }
     
    
    public static void main(String[] args){
        BigONotation test = new BigONotation(100000);
        test.generateArray();
        
        BigONotation test2 = new BigONotation(200000);
        test2.generateArray();
        
         BigONotation test3 = new BigONotation(300000);
        test3.generateArray();
        
         BigONotation test4 = new BigONotation(400000);
        test4.generateArray();
        
//        test.bubbleSort();
//        test2.bubbleSort();
//
//        test.binarySearchForValues(20);
//        test2.binarySearchForValues(20);

        startTime = System.currentTimeMillis();
        
        test.quickSort(0, test.itemsInArray);
//        test2.quickSort(0, test2.itemsInArray);
//        test3.quickSort(0, test3.itemsInArray);
//        test4.quickSort(0, test4.itemsInArray);
        
        
        endTime = System.currentTimeMillis(); 
        System.out.println("Quick Sort Took: " + (endTime - startTime));
    }

}
