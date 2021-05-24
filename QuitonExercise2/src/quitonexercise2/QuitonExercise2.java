
package quitonexercise2;
/**
 *
 * @author Domerck
 */
import java.util.Scanner;
public class QuitonExercise2 {


    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
       int count;
       String input;
       Scanner scan = new Scanner(System.in);
       
       //asks user to input how many number strings
        System.out.print("Enter the number of Strings you want to enter: ");
        count = scan.nextInt();
        
      String strng[] = new String[count];
      Scanner scan2 =  new Scanner(System.in);
      
      //users entered strings are stored in this array
      System.out.println("Enter Strings one at a time: ");
      for(int i = 0; i < count; i++)
      {
       strng[i] = scan2.nextLine();
      }
      scan.close();
      scan2.close();
      
      //strings are bubblesorted here
      for( int i=0; i< count; i++){
          for(int j = i + 1; j < count; j++)
          {
              if (strng[i].compareTo(strng[j])>0)
              {
                  input = strng[i];
                  strng[i] = strng[j];
                  strng[j] = input;
              }
          }
      }
        System.out.println("");
      //diplays raw and result data in alphabetical order
        System.out.println("Strings in Alphabetical Order: ");
        for(int i=0; i<= count-1; i++){
            System.out.println(strng[i] + "");
        
        }
            
      
    }
    
}
