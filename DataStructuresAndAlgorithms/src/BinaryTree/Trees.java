
package BinaryTree;

import java.io.*;
import java.util.*;

public class Trees {
    class Node {
        int data;
        String name;
        Node left, right;
        Node(int data, String name) {
            this.data = data;
            this.name = name;
        }

        public String toString() {
            return name + " has a value of " + data;
        }
    }   
    Node root;
    
    public void add(int data, String name) {
        if (root == null) {
            root = new Node(data, name);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(data, name);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(data, name);
                        return;
                    }
                }
            }
        }
        
    }
    
    public Node find(int key) {
        Node focusNode = root;
        while (focusNode.data != key) {
            if (key <focusNode.data) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
    
    public void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.println(current.toString());
            printInOrder(current.right);
        }
    }
    
    public void printPreOrder(Node current) {
        if (current != null) {
            System.out.println(current.toString());
            printPreOrder(current.left);
            printPreOrder(current.right);
        }
    }
    
    public void printPostOrder(Node current) {
        if (current != null) {
            printPostOrder(current.left);
            printPostOrder(current.right);
            System.out.println(current.toString());
        }
    }
    
    public static void main(String[] args) throws Exception {
        Trees t = new Trees();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " -> ");
        Stack<String> stack = new Stack<String>();
        while (st.hasMoreTokens()) {
            stack.add(st.nextToken());
        }
        System.out.println(stack);
        
    }
}

