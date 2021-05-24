



public class RPNTreeTest {
    static Node root;
    
    static class Node {
        Node left, right;
        char value;
        
        Node(char c) {
            this.value = c;
        }
        
        public char string() {
            return value;
        }
    }
    
    boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }
    
    void inOrderTraversal(Node root) {
        if (root != null) {
        inOrderTraversal(root.left);
        System.out.println(root.string());
        inOrderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Stack<Node> stack = new java.util.Stack();
        RPNTreeTest t = new RPNTreeTest();
        String scan = input.nextLine();
        for (int i = 0; i < scan.length(); i++) {
            char c = scan.charAt(i);
            Node t0, t1, t2;
            if (!t.isOperator(c)) {
                t0 = new Node(c);
                stack.push(t0);
            } else {
                t1 = stack.pop();
                t2 = stack.pop();
                t0 = new Node(c);
                t0.left = t1;
                t0.right = t2;
                stack.push(t0);
            }
        }
        System.out.println(stack.peek());
        t.inOrderTraversal(root);
      
    }
    
}
