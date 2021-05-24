
package Review;


public class BinaryTree {
    class Node {
        int data;
        Node left, right;
        
        Node(int data) { this.data = data; }
    }
    
    Node root;
    
    public void add(int data, Node root) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node current = root;
            if (data < current.data) {
                System.out.println("Hey");
                if (current.left == null) current.left = new Node(data);
                else {
                    current = current.left;
                    System.out.println("hi");
                    add(data, current);
                }
            } else {
                System.out.println("Hello");
                if (current.right == null) current.right = new Node(data);
                else {
                    current = current.right;
                    System.out.println("hello");
                    add(data, current);
                }
            }
        }
    }
    
    //public void add(int data) { add(data, root); }
    
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(data);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(data);
                        return;
                    }
                }
            }
        }
    }
    
    public boolean contains(int data) {
        if (root.data == data) {
            return true;
        } else {
            Node current = root;
            while (true) {
                if (data < current.data) {
                    current = current.left;
                    if (current.data == data) {
                        return true;
                    }
                } else {
                    current = current.right;
                    if (current.data == data) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
    
    
    
    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    
    void inOrder() { inOrder(root); }
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(1);
        bt.add(2);
        bt.add(3);
        System.out.println(bt.contains(4));
        bt.inOrder();
    }
}
