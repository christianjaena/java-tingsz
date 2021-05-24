
package jaenaexercise1a;

import java.util.Scanner;

public class JaenaExercise1a {
    
    private static int[] theArray;
    
    JaenaExercise1a(int size) {
        theArray = new int [size];
    }
    
    public void generateArray() {
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = (int) (Math.random() * 10000) + 1;
        }
    }
    
    public void printArray() {
        for (int i = 0; i < theArray.length; i++) {
            System.out.println("[" + i + "]" + " -> " + theArray[i]);
        }
        System.out.println();
    }
    
    public String linearSearch(int key) {
        String keys = "Key found in index/indices: ";
        boolean keyFound = false;
        for (int i = 0; i < theArray.length; i++) {
            if (key == theArray[i]) {
                keys += "[" + i + "]";
                keyFound = true;
            }
        } 
        if(!keyFound) {
            keys = "KEY NOT FOUND.\n";
        }
        return keys;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program will generate random elements between 1 - 10000.");
        System.out.print("Enter size of the array: ");
        int size = input.nextInt();
        JaenaExercise1a ex = new JaenaExercise1a(size);
        ex.generateArray();
        ex.printArray();
        boolean stopSearch = false;
        int searchPrompt;
        do {
            System.out.print("Enter key to search: ");
            int key = input.nextInt();
            System.out.println(ex.linearSearch(key)); 
            
            do {
                System.out.println("Press 1 to search again, 0 to exit the program.");
                searchPrompt = input.nextInt();
                if(searchPrompt == 1) stopSearch = false;
                else if (searchPrompt == 0) {
                    System.out.println("You have exited the program.");
                    stopSearch = true;
                }
                else System.out.println("1 and 0 only.");
            } while(searchPrompt != 1 && searchPrompt != 0);
        } while (!stopSearch);
        
    }

}
