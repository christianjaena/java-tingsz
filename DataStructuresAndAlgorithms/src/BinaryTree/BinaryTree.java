
package BinaryTree;


public class BinaryTree {
    Node root;
  
    BinaryTree() { root = null; }
    
    private static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }
    
    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder() { printPostOrder(root); }
    void printInOrder() { printInOrder(root); }
    void printPreOrder() { printPreOrder(root); }
    
    void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value <= current.key) {
                    current = current.left;
                    if (current.left == null) {
                        parent.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder();
        System.out.println("\nPostOrder traversal of binary tree is ");
        tree.printPostOrder();
    }
}

