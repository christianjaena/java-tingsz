
package Recursion;


public class Recursion {
    
    public static void main(String[] args){
        Recursion r = new Recursion();
        System.out.println("TN: " + r.getFactorial(6));
      
    }
    
    public int getTriangularNum(int number){
        int triangularNumber = 0;
        
        while(number > 0){
            triangularNumber = triangularNumber + number;
            number--;
        }
        
        return triangularNumber;
    }
    
    public int getTriangularNumR(int number){
        System.out.println("Method " + number);
        
        if(number == 1){
            System.out.println("Returned 1");
            return 1;
        }else{
            int result = number + getTriangularNumR(number-1);
            System.out.print("Returned " + result);
            System.out.println(" : " + number + " + getTN(" + number + " -1)");
            return result;
        }
    }
    
    public int getFactorial(int number){
        System.out.println("Method " + number);
        
        if(number == 1){
            System.out.println("Returned 1");
            return 1;
        }else{
            int result = number * getFactorial(number - 1);
            System.out.print("Returned " + result);
            System.out.println(" : " + number + " * getFACT(" + number + " -1)");
            return result;
        }
    }
    
  
    
}
