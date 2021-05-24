
package jaenaexercise2;

import java.util.Scanner;
public class JaenaExercise2 {
     
    static Scanner input = new Scanner(System.in);
    static char[] charArray;
    static String inputString;
    static int num;
    static String[] stringArray = new String[num];
    static String[] raw = new String[num];
    
    public void sortStringAsLetters() {
        getNumberOfStrings();
        for (int i = 0; i < num; i++) {
            getInputStringsChar();
            sortCharArray();
            printCharArray();
        }
    }
    
    public void sortStringAsWords() {
        getNumberOfStrings();

             System.out.println("Enter the number of Strings you'll input: ");
            num = input.nextInt();
            copyInputStrings();
            sortStringArray();
            printStringArray();
        
    }
    
    public void sortCharArray() {
        for (int i = 0; i < charArray.length - 1; i++) {
             int j = i;
             int toInsert = charArray[i];
             while (j > 0 && (charArray[j] > toInsert)) {
                 j = toInsert;
                 j--;
             }
             swap(i, toInsert);
        }
        printCharArray();
    }
    
    public void swap (int a, int b) {
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
    }
    
    public void sortStringArray() {
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray.length - 1; j++) {
                if (stringArray[j].compareToIgnoreCase(stringArray[j+1]) > 0) {
                    String temp = stringArray[j];
                    stringArray[j] = stringArray[j+1];
                    stringArray[j+1] = temp;
                }
            }
        }
    }
    
    public void getNumberOfStrings() {
       
    }
    
    public void getInputStringsChar() {
        System.out.println("Enter Strings");
        inputString = input.next();
        charArray = inputString.toCharArray();
    }
    
     public void getInputStringsWords() {
        System.out.println("Enter name:");
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = input.next();
        }
    }
    
    public void printCharArray() {
        String sortedString = " ";
        String result = " " + "\n";
        for (int i = 0; i < charArray.length; i++) {
            sortedString += charArray[i];
        }
        String inputAndSorted = inputString + "|" + sortedString;
        result += inputAndSorted;
        System.out.println(result);
    }
    
    public void printStringArray() {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("| " + raw[i] + " | " + stringArray[i] + " |");
            System.out.println();
        }
    }
    
    public void copyInputStrings() {
        for (int i = 0; i < stringArray.length; i++) {
            raw[i] = stringArray[i];
        }
    }
  
    public static void main(String[] args) {
        JaenaExercise2 exe = new JaenaExercise2();
        int choice;
        do {
            System.out.println("Sort Strings as Letters (1) or Sort Strings as Words (2): ");
            choice = input.nextInt();

            if (choice == 1) {
                exe.sortStringAsLetters();
            } else if (choice == 2) {
               exe.sortStringAsWords();
            } else {
                System.out.println("1 & 2 only.");
            }
        } while (choice != 1 && choice !=2);

    }

}
