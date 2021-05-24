
package Recursion;


public class Recursion2 {
    
    public static void main(String[] args){
       Recursion2 rr = new Recursion2();
       
        System.out.println(rr.getRecursion(5));
    }
    
    public int getRecursion(int n){
        if(n<=0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return getRecursion(n-1) + getRecursion(n-2);
        }
        
    }
    
}
