 package BinaryTree;

public class Node {
    Node left, right;
    int data;
    Node(int data) {
        this.data = data;
    }
    
    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }
    
    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }
    
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }
    
    public void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
    }
    
    public void printPostOrder() {
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
        System.out.println(data);
    }
    
    public static void main(String[] args) {
        Node n = new Node (10);
        n.insert(5);
        n.insert(15);
        //n.printInOrder();
        n.printPostOrder();
        n.insert(8);
        n.printPostOrder();
    }
}




