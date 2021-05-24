
package jaenaexercise1b;

import java.util.Scanner;

public class JaenaExercise1b {
    
    private int[][] theArray;
    
    JaenaExercise1b(int rows, int columns){
        theArray = new int[rows][columns];
    }
    
    public void generateArray() {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                theArray[i][j] = (int) (Math.random() * 10000) + 1;
            }
        }
    }
    
    public void printArray(int columns) {
        String space = " ";
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                System.out.printf("%2s[%d,%d] -> %-2d  ",space, i , j , theArray[i][j]);
            }
            System.out.println();
        }
    }
    
    public String linearSearch(int key) {
        String keys = "Key found in index/ indices: ";
        boolean keyFound = false;
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                if (key == theArray[i][j]) {
                    keys += "[" + i + "," + j + "]";
                    keyFound = true;
                }
            }
        }
        if (!keyFound) {
            keys = "KEY NOT FOUND.\n";
        }
        return keys;
    }
    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("This program will generate random elements between 1 - 10000.");
       System.out.print("Enter size of the ROWS of the 2d array: ");
       int rows = input.nextInt();
       System.out.print("Enter the size of the COLUMNS of the 2d array: ");
       int columns = input.nextInt();
       JaenaExercise1b ex = new JaenaExercise1b(rows,columns);
       ex.generateArray();
       ex.printArray(columns);       
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
