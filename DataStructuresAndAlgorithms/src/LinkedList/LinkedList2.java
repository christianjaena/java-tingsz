
package LinkedList;


public class LinkedList2 {
    Node2 head;
    
    public void append(int data) {
        if (head == null) {
            head = new Node2(data);
            return;
        }
        Node2 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node2(data);
    }
    
    public void prepend(int data) {
        Node2 newHead = new Node2(data);
        newHead.next = head;
        head = newHead;
    }
    
    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        Node2 current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    public void print() {
        Node2 current = head;
        int counter = 0;
        while (current != null) {
            System.out.println("Link " + ++counter + ": -> "  + current.data);
            current = current.next;
        }
        System.out.println();
    }
    
    public void insertionSort() {
        Node2 current = head;
        while (current != null) {
           
            if (current.data > current.next.data) {
                Node2 temp = current.next.next;
                System.out.println("current.next.next: " + current.next.next);
                
                current.next = current.next.next;
                //System.out.println("current.next.next: " + current.next.next);
                System.out.println("current.next:" + current.next);
                current.next = temp;
                //System.out.println("temp: " + temp);
                System.out.println("current.next: " + current.next);
            }
            current = current.next;
        }
    } 
    
    public void swap (int first, int sec) {
        int temp = first;
        first = sec;
        sec = temp;
    }

    public static void main(String[] args) {
        LinkedList2 l = new LinkedList2();
        l.prepend(1);
        l.append(18);
        l.append(9);
        l.prepend(2);
        l.print();
        l.insertionSort();
        l.print();
    }
}

class Node2 {
    Node2 next;
    Node2 prev;
    int data;
    
    Node2 (int data) {
        this.data = data;
    }
}
