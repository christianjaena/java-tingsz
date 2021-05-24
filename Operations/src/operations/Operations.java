
package operations;

import java.util.Scanner;

public class Operations {

  
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println("Enter of Letter of Operation: ");
        String operation = input.nextLine();
        System.out.println("Enter 1st integer: ");
        int firstNum = input.nextInt();
        System.out.println("Enter 2nd integer: ");
        int secNum = input.nextInt();
        
        switch (operation) {
            case "A":
            case "a":
                System.out.println(addition(firstNum,secNum));
                break;
            case "S":
            case "s":
                System.out.println(subtraction(firstNum,secNum));
                break;
            case "M":
            case "m":
                System.out.println(multiplication(firstNum,secNum));
                break;
            case "D":
            case "d":
                System.out.println(division(firstNum,secNum));
        }

    }
    
    public static String addition(int a, int b) {
        return a + " + " + b + " = " + ((int)a + b);
    }
    
    public static String subtraction(int a, int b) {
        if (a < b) return b + " - " + a + " = " + ((int)b - a);
        else return a + " - " + b + " = " + ((int)a - b);    
    }
    
    public static String multiplication(int a, int b) {
        return a + " * " + b + " = " + ((int)a * b);
    }
    
    public static String division(int a, int b) {
        if (a < b) return b + " / " + a + " = " + ((int)b / a);
        else return a + " / " + b + " = " + ((int)a / b);
    }

}
