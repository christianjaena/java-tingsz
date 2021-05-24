import java.util.Arrays;  import java.util.Scanner;

public class NewMain {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Enter desired Array size:");
       int arraySize = input.nextInt();
       
       int[] arrayThisIsIt = new int[arraySize];
       for(int i = 0; i < arrayThisIsIt.length;i++) {
           arrayThisIsIt[i] = (int) ((Math.random() *10000) + 1);
          
       }
       
       System.out.println(Arrays.toString(arrayThisIsIt));
       System.out.print("Enter Desired Number To Be Search:");
       int number = input.nextInt();
       
       String result = "Number is found in the index/indeces";
       boolean numberFound = false;
       
       for (int i = 0; i < arrayThisIsIt.length; i++){
           if(number == arrayThisIsIt[i]){
               result += i + ",";
               numberFound = true;
           }
       }
       if(numberFound == false); {
        result = "Desired Number Is not Found";
    }
       
       System.out.print(result);
    }
    
}
