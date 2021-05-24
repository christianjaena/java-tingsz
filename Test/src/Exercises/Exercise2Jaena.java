
package exercise2jaena;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2Jaena {
    static Scanner input = new Scanner(System.in);
    static String[] stringArray = new String[100];
    static String[] stringArrayCopy = new String[100];
    static String[] inputString = new String[100];
    static char[] charArray;
    static String[] sortedCharArray = new String[100];
    static int stringArraySize = 1;
    
    public void sortStringAsWords() {
        int choice;
        do {
            System.out.println("Press (1) to sort by Insertion Sort.\nPress (2) to sort by Bubble Sort.\nPress (3) to sort by QuickSort.");
            choice = input.nextInt();
            if (choice == 1) {
                insertionSortWords();
            } else if (choice == 2) {
                bubbleSortWords();
            } else if (choice == 3) {
                quickSortWords();
            } else {
                System.out.println("Choose 1, 2 and 3 only.");
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }
    
    public void insertionSortWords() {
        for (int i = 0; i < stringArraySize; i++) {
            System.out.println("Enter Strings (-1 to stop): ");
            stringArray[i] = input.next();
            if ("-1".equals(stringArray[i])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            stringArrayCopy[i] = stringArray[i];
            stringArraySize++;
            if (stringArray[1] != null) {
                // INSERTION SORT ALGORITHM
                for (int k = 0; k < i + 1; k++) {
                    int j = k;
                    String toInsert = stringArray[k];
                    while (j > 0 && stringArray[j - 1].compareToIgnoreCase(toInsert) > 0) {
                        stringArray[j] = stringArray[j - 1];
                        j--;
                    }
                    stringArray[j] = toInsert;
                }
                // END OF INSERTION SORT ALGORITHM
            }
            printStringArray();
        }
    }
     
    public void bubbleSortWords() {
        for (int i = 0; i < stringArraySize; i++) {
            System.out.println("Enter Strings (-1 to stop): ");
            stringArray[i] = input.next();
            if ("-1".equals(stringArray[i])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            stringArrayCopy[i] = stringArray[i];
            stringArraySize++;
            if (stringArray[1] != null) {
                // BUBBLE SORT ALGORITHM
                for (int k = 0; k < i + 1; k++) {
                    for (int j = 0; j < i + 1; j++) {
                        if (stringArray[k].compareToIgnoreCase(stringArray[j]) < 0) {
                            String temp = stringArray[k];
                            stringArray[k] = stringArray[j];
                            stringArray[j] = temp;
                        }
                    }
                } 
                // END OF BUBBLE SORT ALGORITHM
            }
            printStringArray();
        }
    }
    
    public void quickSortWords() {
        for (int i = 0; i < stringArraySize; i++) {
            System.out.println("Enter Strings (-1 to stop): ");
            stringArray[i] = input.next();
            if ("-1".equals(stringArray[i])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            stringArrayCopy[i] = stringArray[i];
            stringArraySize++;
            if (stringArray[1] != null) {  
                quickSortWords(0, i-1); 
            }
            printStringArray();
        }
    }
    
    // QUICK SORT ALGORITHM
    public void quickSortWords(int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = Arrays.asList(stringArray).indexOf(stringArray[(left + right) / 2]);
        int index = partitionWords(left, right, pivot);
        quickSortWords(left, index - 1);
        quickSortWords(index, right);
    }
    
    public int partitionWords(int left, int right, int pivot) {
        while (left <= right) {
            while (stringArray[left].compareToIgnoreCase(stringArray[pivot]) < 0) {
                left++;
            }
            while (stringArray[right].compareToIgnoreCase(stringArray[pivot]) > 0) {
                right--;
            }
            if (left <= right) {
                String temp = stringArray[left];
                stringArray[left] = stringArray[right];
                stringArray[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    // END OF QUICK SORT ALGORITHM
    
    public void printStringArray() {
        System.out.println("-------------------------------------------------");
        System.out.printf("%-5s %-10s %5s %20s %5s\n", "|", "Raw Input", "|","Sorted Input", "|");
        for (int i = 0; i < stringArraySize - 1; i++) {  
            System.out.println("-------------------------------------------------");
            System.out.printf("%-5s %-10s %5s %15s %10s\n", "|",stringArrayCopy[i], "|", stringArray[i], "|");
            System.out.println("-------------------------------------------------");
        }
        System.out.println();
    }
    
    public void sortStringByLetters() {
        int choice;
        do {
            System.out.println("Press (1) to sort by Insertion Sort.\nPress (2) to sort by Bubble Sort.\nPress (3) to sort by QuickSort.");
            choice = input.nextInt();
            if (choice == 1) {
                insertionSortLetters();
            } else if (choice == 2) {
                bubbleSortLetters();
            } else if (choice == 3) {
                quickSortLetters();
            } else {
                System.out.println("Choose 1, 2 and 3 only.");
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }
    
    public void insertionSortLetters() {
        for (int k = 0; k < stringArraySize; k++) {
            System.out.println("Enter Strings (-1 to stop): ");
            inputString[k] = input.next();
            if ("-1".equals(inputString[k])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            charArray = inputString[k].toLowerCase().toCharArray();
            stringArraySize++;
            // INSERTION SORT ALGORITHM
            for (int i = 0; i < charArray.length; i++) {
                int j = i;
                char toInsert = charArray[i];
                while (j > 0 && charArray[j - 1] > toInsert) {
                    charArray[j] = charArray[j - 1];
                    j--;
                }
                charArray[j] = toInsert;
            }
            // END OF INSERTION SORT ALGORITHM
            String sorted = "";
            for (int i = 0; i < charArray.length; i++) {
                sorted += charArray[i];
            }
            sortedCharArray[k] = sorted;
            printCharArray();
        }
    }
    
    public void bubbleSortLetters() {
        for (int k = 0; k < stringArraySize; k++) {
            System.out.println("Enter Strings (-1 to stop): ");
            inputString[k] = input.next();
            if ("-1".equals(inputString[k])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            charArray = inputString[k].toLowerCase().toCharArray();
            stringArraySize++;
            // BUBBLE SORT ALGORITHM
            for (int i = 0; i < charArray.length - 1; i++) {
                for (int j = 0; j < charArray.length - 1; j++) {
                    if (charArray[j] > charArray[j + 1]) {
                        char temp = charArray[j];
                        charArray[j] = charArray[j + 1];
                        charArray[j + 1] = temp;
                    }
                }
            }
            //END OF BUBBLE SORT ALGORITHM
            String sorted = "";
            for (int i = 0; i < charArray.length; i++) {
                sorted += charArray[i];
            }
            sortedCharArray[k] = sorted;
            printCharArray();
        }
    }
    
    public void quickSortLetters() {
        for (int k = 0; k < stringArraySize; k++) {
            System.out.println("Enter Strings (-1 to stop): ");
            inputString[k] = input.next();
            if ("-1".equals(inputString[k])) {
                System.out.println("You have exited the program.");
                System.exit(0);
            }
            charArray = inputString[k].toLowerCase().toCharArray();
            stringArraySize++;
            quickSortLetters(0, charArray.length - 1);
            String sorted = "";
            for (int i = 0; i < charArray.length; i++) {
                sorted += charArray[i];
            }
            sortedCharArray[k] = sorted;
            printCharArray();
        }
    }
    // QUICK SORT ALGORITHM
    public void quickSortLetters(int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = charArray[(left + right) / 2];
        int index = partitionLetters(left, right, pivot);
        quickSortLetters(left, index - 1);
        quickSortLetters(index, right);
    }
    
    public int partitionLetters(int left, int right, int pivot) {
        while (left <= right) {
            while (charArray[left] < pivot) {
                left++;
            }
            while (charArray[right] > pivot) {
                right--;
            }
            if (left <= right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    //END OF QUICK SORT ALGORITHM
    public void printCharArray() {
        System.out.println("-------------------------------------------------");
        System.out.printf("%-5s %-10s %5s %20s %5s\n", "|", "Raw Input", "|","Sorted Input", "|");
        for (int i = 0; i < stringArraySize - 1; i++) {  
            System.out.println("-------------------------------------------------");
            System.out.printf("%-5s %-10s %5s %15s %10s\n", "|",inputString[i], "|", sortedCharArray[i], "|");
            System.out.println("-------------------------------------------------");
        }
        System.out.println();
    }
  
    public static void main(String[] args) {
       Exercise2Jaena exe = new Exercise2Jaena();
       int choice;
       boolean match = false;
       try {
            do {
             System.out.println("Press (1) to sort String as Words.\nPress (2) to sort String by Letters.");
             choice = input.nextInt();
             if (choice == 1) {
                 exe.sortStringAsWords();
             } else if (choice == 2) {
                 exe.sortStringByLetters();
             } else {
                 System.out.println("Choose 1 and 2 only.");
             }
            } while (choice != 1 && choice !=2);
       } catch (InputMismatchException e) {
           System.out.println("Enter integers only. Kindly restart the program.");
       }
    }

}
