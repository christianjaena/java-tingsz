
package Review;


public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    Node root;
    Node tail;
    
    public void append(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = tail = new Node(value);
            tail.prev = current;
            
        }
    }
    
    public void print() {
        Node current = root;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public void reversePrint() {
        Node current = tail;
        while (current != root) {
            System.out.println(current.data);
            current = current.prev;
        }
        System.out.println(root.data);
    }
    
    public void pop() {
        tail = tail.prev;
        tail.next = null;
        print();
    }
    
    public void rootCanal() {
        root = root.next;
        print();
    }
    
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = root;
        root.prev = newNode;
        root = newNode;
    } 
    
    public void deleteAt(int value) {
        Node current = root;
        while (current.data != value) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
    
    public void replace(int value, int data) {
        Node current = root;
        while (current.data != value) {
            current = current.next;
        }
        current.data = data;
    }
    
    public void insertAt(int value, int data) {
        Node current = root;
        while (current.data != value) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next.prev = newNode;
        newNode.next = current.next;
        current.next = newNode;
        newNode.prev = current;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        d.append(1);
        d.append(2);
        d.append(3);
//        d.print();
//        d.reversePrint();
//        d.pop();
//        d.rootCanal();
        d.prepend(18);
        d.print();
        d.deleteAt(2);
        d.replace(1, 20);
        d.insertAt(20, 30);
        d.print();
    }
}
