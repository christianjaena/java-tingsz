
package experiment;
import java.util.Arrays;
public class Experiment {

    public static int[] theArray;
    public static int arraySize;
    
    Experiment(int size) {
        theArray = new int[size];
    }
    
    public void generateArray() {
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }
    
    public void displayArray() {
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(i + " -> " + theArray[i]);
        }
    }
    
    public static void main(String[] args) {
        Experiment ex = new Experiment(10);
        ex.generateArray();
        ex.displayArray();
        Arrays.sort(theArray);
        System.out.println();
        ex.displayArray();
        System.out.println(Arrays.binarySearch(theArray, 17));
    }

}
