
package Queue;

import java.util.Arrays;

public class Queue {
    
    private String[] queueArray;
    
    private int queueSize;
    
    private int front, rear, numberOfItems = 0;
    
    Queue(int size){
        
        queueSize = size;
        
        queueArray = new String[size];
        
        Arrays.fill(queueArray, "-1");
        
    }
    
    public void insert(String input){
        
        if(numberOfItems + 1 <= queueSize){
            
            queueArray[rear] = input;
            
            rear++;
            
            numberOfItems++;
            
            System.out.println("INSERT " + input + " was added to the Queue");
            
            displayTheQueue();
            
        } else{
            
            System.out.println("Sorry but the queue is full");
            
        }
    }
    
    public void remove(){
        if(numberOfItems > 0){
            System.out.println("REMOVE " + queueArray[front] + " was removed from the Queue");
            queueArray[front] = "-1";
            front++;
            numberOfItems--;
            displayTheQueue();
            
        }else System.out.println("Sorry the queue is empty");

    }
    
    public void displayTheQueue(){
        for (int i = 0; i < queueSize; i++) {
            System.out.println(i + " -> " + queueArray[i]);
        }
    }
    public void peek(){
        System.out.println("The first element is " + queueArray[front]);
    }
    
    public void priorityInsert(String input){
        int i;
        if(numberOfItems == 0) insert(input);
        
        else{
            for (i = numberOfItems - 1; i >= 0; i--) {
                if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                }else break;
            }
            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
            
        
    }
    
    public static void main(String[] args){
        Queue queue = new Queue(10);
        queue.priorityInsert("18");
        queue.priorityInsert("19");
        queue.priorityInsert("16");
        
        queue.remove();
        queue.peek();
    }
}
