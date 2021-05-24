
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LinkList2 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(System.out);
    static StringTokenizer st;
    static int T;
    static int N;
    static int K;
    static boolean deleteFriend = false;
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
        current.next.prev = current;
    }
    
    public void deleteFriends() {
        if (head == null) {
            return;
        }
        if (head.data < head.next.data) {
            head = head.next;
            deleteFriend = true;
        }
        Node current = head;
        
        while (current.next != null) {
            if (current.data < current.next.data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                deleteFriend = true;
                return;
            }
            current = current.next;
        }
    }
    
    public void deleteEnd() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    
    public void clear() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        head = current.next; 
    }
    
    public void print() {
        Node current = head;
        while (current != null) {
            pr.print(current.data + " ");
            current = current.next;
        }
        pr.print("\n");
        
    }
    
    public static void main(String[] args) throws Exception {
        LinkList2 l = new LinkList2();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                l.append(Integer.parseInt(st.nextToken())); 
            }
            for (int j = 0; j < K; j++) {
                l.deleteFriends();
                if (!deleteFriend) {
                l.deleteEnd();
                }
            }
            l.print();   
            l.clear(); 
            
        }
        pr.flush();
        pr.close();
    }
}

class Node {
    Node next;
    Node prev;
    int data;
    Node (int data) {
        this.data = data;
    }
}