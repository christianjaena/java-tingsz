
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class RPNTree {
    static Stack<Double> stack = new Stack<>();
    static String output = "";
    static PrintWriter pw = new PrintWriter(System.out);
    static String[] array = new String[100];
    static int arrayLength = 10;
    
    private class Node {
        String value;
        Node left, right;        
        
        Node(String value) {
            this.value = value;
        }
    }

    public boolean isOperator(String c) { return c.equals("+") || c.equals("-")|| c.equals("*") || c.equals("/")  || c.equals("^"); }
    
    // Inorder traversal to produce Infix expression.
    public void inOrder(Node t) {
        if (t == null) return;
        inOrder(t.left);
        output += t.value;
        inOrder(t.right);
        checkOperatorOrOperand(t.value);
    }
    
    // A function to separate Operators and Operands.
    public void checkOperatorOrOperand(String c) {
        switch(c) {
                case "+":
                    pw.print("Operate\t\t");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    pw.print("Operate\t\t");
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    pw.print("Operate\t\t");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    pw.print("Operate\t\t");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    pw.print("Operate\t\t");
                    double exp = stack.pop();
                    stack.push(Math.pow(stack.pop(), exp));
                    break;
                default:
                    pw.print("Push\t\t");
                    stack.push(Double.parseDouble(c));
                    break;
        }
        pw.printf("%.2f", stack.peek());
        pw.println("\t\t" + stack);
    }
    
    // Returns root of constructed tree for given postfix expression.
    public Node constructTree(String postfix[]) {
        Stack<Node> st = new Stack();
        Node t, t1, t2;
        for (int i = 0; i < arrayLength ; i++) {
            // Pushes operands to stack.
            if (postfix[i] != null) {
                if (!isOperator(postfix[i])) {
                    t = new Node(postfix[i]);
                    st.push(t);
                } else {    
                    // Pops two operands from stack making them children of the operator as root then pushes to stack.          
                    t = new Node(postfix[i]);                  
                    t1 = st.pop();
                    t2 = st.pop();   
                    t.right = t1;
                    t.left = t2;               
                    st.push(t);
                }
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RPNTree t = new RPNTree();
        pw.print("Enter Postfix Expression(ex. 3 5 +): ");
        pw.flush();
        StringTokenizer st = new StringTokenizer(br.readLine()); br.close();
        for (int i = 0; st.hasMoreTokens(); i++, arrayLength++)  array[i] = st.nextToken();
        Node root = t.constructTree(array);
        pw.println("Operation\tElement\t\tStack");
        t.inOrder(root);
        pw.println();
        pw.println("Infix expression is: " + output);
        pw.printf("Final Answer: %.2f ", stack.peek());
        pw.close();
    }
}

