
package Review;


public class LinkedList {
    class Node {
        int key;
        Node next;
        
        Node(int key) {
            this.key = key;
        }
    }
    
    Node root;
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(key);
        }
    }
    
    public void insertAtFirst(int key) {
        Node newHead = new Node(key);
        newHead.next = root;
        root = newHead;
    }
    
    public void insertAt(int key, int value) {
        Node current = root;
        if (current.key == key) {
            Node newNode = new Node(value);
            current.next = newNode;
            newNode.next = current.next.next;
        } else {
            while (current.key != key) {
                current = current.next;
            }
            Node newNode = new Node(value);
            current.next = newNode;
            newNode.next = current.next.next;
        }
    }
    
    public void delete(int key) {
        Node current = root;
        if (root.key == key) {
            root  = root.next;
        }
        while (current.next.key != key) {
            current = current.next;
        }
        current.next = current.next.next;
    }
    
    public void print() {
        Node current = root;
        while (current != null) {
            System.out.println(current.key);
            current = current.next;
        }
    }
    
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insertAtFirst(4);
        //ll.insertAt(0, 18);
        ll.delete(4);
        ll.print();
    }
}
