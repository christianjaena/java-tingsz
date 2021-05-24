import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;
 
public class LinkList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> tempStack = new Stack<>();
    static PrintWriter pr = new PrintWriter(System.out);
    static StringTokenizer st;
    static int N;
    Node head;
    
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }
    
    public void print() {
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp % 2 == 0) {
                tempStack.push(temp);
            } else {     
                while (!tempStack.isEmpty()) {
                    int pop = tempStack.pop();
                    pr.print(pop + " ");
                    append(pop);
                }
                pr.print(temp + " ");
                append(temp);
            }
        }
        while (!tempStack.isEmpty()) {
            int pop = tempStack.pop();
            pr.print(pop + " ");
            append(pop);
        }
        pr.flush();
        pr.close();
    }
    
    public static void main(String[] args) throws Exception {
        LinkList l = new LinkList();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        l.print();
    }   
}   
 
class Node {
    Node next;
    int data;
    Node (int data) {
        this.data = data;
    }
}