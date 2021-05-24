
package Stack;

import java.util.Arrays;


public class Stack {
    
    private String[] theStack;
    
    private int stackSize;
    
    private int topOfStack = -1;
    
    Stack(int size){
        
        stackSize = size;
        
        theStack = new String[size];
        
        Arrays.fill(theStack, "-1");
    }
    
    public void push(String input){
        
        if(topOfStack + 1 < stackSize){
            topOfStack++;
            theStack[topOfStack] = input;
            
        }else System.out.println("Sorry but the Stack is full");
            
        displayTheStack();
        
        System.out.println("PUSH " + input + " was added to the Stack");
        
    }
    
    public String pop(){
        if(topOfStack >= 0){
            displayTheStack();
            
            System.out.println("POP " + theStack[topOfStack] + " was removed from the Stack");
            
            theStack[topOfStack] = "-1";
            
            return theStack[topOfStack--];
        }else{
            displayTheStack();
            System.out.println("Sorry but the Stack is empty");
            
            return "-1";
        }
    }
    
    public String peek(){
        displayTheStack();
        
        System.out.println("PEEK " + theStack[topOfStack] + " is at the top of the Stack");
        
        return theStack[topOfStack];
    }
    
    public void displayTheStack(){
        for (int i = 0; i < stackSize; i++) {
            if(theStack[i] == "-1"){
                theStack[i] = "EMPTY";
            }
            System.out.println(i + " -> " + theStack[i]);
        }
    }
    
    public void pushMany(String multipleValues){
        String[] tempString = multipleValues.split(" ");
        
        for (int i = 0; i < tempString.length; i++) {
            push(tempString[i]);
        }
    }
    
    public void popAll(){
        for (int i = topOfStack; i >= 0; i--) {
            pop();
        }
    }

    public static void main (String[] args){
       
        Stack stack = new Stack(10);

        stack.pushMany("Christian Jaena");
        stack.popAll();
       
        
    }
    
    
}
