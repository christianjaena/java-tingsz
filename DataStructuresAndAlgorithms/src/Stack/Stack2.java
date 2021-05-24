
package Stack;


public class Stack2 {
    
    int[] stack = new int[5];
    int top = 0;
    
    
    
    public void push(int data){
        stack[top] = data;
        top++;
    }
    
    public int pop(){
        int data = 0;
        
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            top--;
            data = stack[top];
            stack[top] = 0;
        
        }
        return data;
    }
    
    public int peek(){
        int data;
        data = stack[top - 1];
        return data;
        
    }
    public void show(){
        for (int  n : stack){
            System.out.println(n + " ");
        }
    }
    
    public int size(){
        return top;
    }
    
    public boolean isEmpty(){
        return top <= 0;
    }
    
    public static void main(String[] args){
       Stack2 s = new Stack2();
       s.push(1);
       s.push(2);
       s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println("Size is " + s.size());
       s.show();
        System.out.println(s.isEmpty());
       
    }
    
}
