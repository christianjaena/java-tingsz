
package Queue;


public class Queue2 {
    int[] queue = new int[5];
    int size;
    int front;
    int rear;
    
    public void enqueue(int data){
        queue[rear] = data;
        rear++;
        size++;
    }
    
    public int dequeue(){
        int data = queue[front];
        front++;
        size--;
        
        return data;
    }
    
    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(queue[front + i] + " ");
        }
    }
    
    public static void main(String[] args){
        Queue2 q = new Queue2();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.show();
        System.out.println();
        q.dequeue();
        q.show();
    }

}
