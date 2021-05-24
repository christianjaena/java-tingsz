import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Tree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pw = new PrintWriter(System.out);
    Node root;
    
    public void insert(String parent, String value) {
        Tree t  = new Tree();
        if (root == null) {
            root = new Node(parent);
            if (root.value.compareToIgnoreCase(value) > 0) {
                root.left = new Node(value);
            } else {
                root.right = new Node(value);
            }
        } else {
            Node current = root;
            Node parentNode;
            while (true) {
                parentNode = current;
                if (current.value.equals(parent)) {
                    current = current.left;
                    if (current == null) {
                        parentNode.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parentNode.right = new Node(value);
                        return;
                    }
                }
            }
            
        }
    }
    
    public void recursivePrint(Node root) {
        if (root != null) {
            recursivePrint(root.left);
            recursivePrint(root.right);
            pw.print(root.value + "\n");
        }   
    }
    
    public static void main(String[] args) throws Exception {
        Tree t = new Tree();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " -> ");
            while (st.hasMoreTokens()) {
                t.insert(st.nextToken(), st.nextToken());
            }
        }
        t.recursivePrint(t.root);
        pw.flush();
        pw.close();
    }
}

class Node {
    Node left, right;
    String value;
    
    Node(String value) {
        this.value = value;
    }
}