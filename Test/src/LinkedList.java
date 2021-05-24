

import java.util.*;

public class LinkedList {
    Node head;
    static Stack<Integer> stack = new Stack<Integer>();
    
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }
    
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public void addToStack() {
        Node current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
    }
    
    public void reverse() {
        Node current = head;
        while (current != null) {
            current.data = stack.pop();
            current = current.next;
        }
    }
    
    public int length() {
        int length = 0;
        Node current = head; 
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    public void remove(int data) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
        }
    }
    
    public void checkDuplicate() {
        Node current = head;
        while (current != null) {
            if (checkDuplicate(current.data)) {
                remove(current.data);
            }
        }
    }
    
    public boolean checkDuplicate(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(3);
        l.add(2);
        l.add(3);
        l.print();
        l.checkDuplicate();
        l.addToStack();
        l.reverse();
        l.print();
        System.out.println(l.length());
    }
    class Node {
    Node next;
    int data;
    Node(int data) { this.data = data; }
}
} 


