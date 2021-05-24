
package SortingAlgorithms;


public class Array2 {
    
    private static int[] array = new int[50];
    public static int arraySize = 10;
    static int count = 0;
    
    public void printArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + " -> " + array[i]);
        }
        System.out.println();
    }
    
    public void insertValue(int value) {
        array[count++] = value;
    }
    
    public void insertValueAt(int value, int index) {
        for (int i = index; i < 10; i++) {
            array[i] = array[i + 1];
        }
        array[index] = value;
    }
    
    public void deleteIndex(int index) {
        for (int i = index; i < arraySize; i++) {
            array[i] = array[i + 1];
        }
        arraySize--;
    }
    
    public int search(int value) {
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    void deleteFromEnd() {
        arraySize--;
    }
    
    void deleteFromStart() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = array[i + 1];
        }
        arraySize--;
    }
    
    void deleteValue(int value) {
        int valueFound = -1;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                valueFound *= -i;
            }
        } 
        if (valueFound == -1) {
            System.out.println("No value found");
        } else {
            for (int i = valueFound; i < arraySize; i++) {
                array[i] = array[i + 1];
            }
        }
    }
    public static void main(String[] args) {
        Array2 a = new Array2();
        a.insertValue(1);
        a.insertValue(2);
        a.insertValue(3);
        a.insertValueAt(4,3);
        a.printArray();
        a.deleteValue(3);
        a.printArray();
    }
}
