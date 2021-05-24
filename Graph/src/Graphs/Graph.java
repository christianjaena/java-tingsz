
package Graphs;

import java.io.*;
import java.util.*;

public class Graph {
    int vertices;
    ArrayList<Integer> adjacentList[];
    
    Graph(int vertices) {
        this.vertices = vertices;
        adjacentList = new ArrayList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            adjacentList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int source, int destination) {
        adjacentList[source].add(destination);
        adjacentList[destination].add(source);
    }
    
    public void shortestPath(int source, int destination) {
        boolean isVisited[] = new boolean[vertices];
        int parent[] = new int[vertices];
        isVisited[source] = true;
        parent[source] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int n = queue.remove();
            for (int i = 0; i < adjacentList[n].size(); i++) {
                int v = adjacentList[n].get(i);
                if (!isVisited[v]) {
                    isVisited[v] = true;
                    parent[v] = n;
                    queue.add(v);
                }
            }
        }
        Stack<Integer> stack = new Stack();
        while (parent[destination] != -1) {
            stack.push(destination);
            destination = parent[destination];
        }
        stack.push(source);
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + 1 + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int T = Integer.parseInt(s[2]);
        int C = Integer.parseInt(s[3]);
        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            String queue[] = br.readLine().split(" ");
            int U = Integer.parseInt(queue[0]);
            int V = Integer.parseInt(queue[1]);
            g.addEdge(U - 1, V - 1);
        }
        String queue[] = br.readLine().split(" ");
        int x = Integer.parseInt(queue[0]);
        int y = Integer.parseInt(queue[1]);
        for (int i = 0; i < N; i++) {
            Collections.sort(g.adjacentList[i]);
        }
        g.shortestPath(x - 1, y - 1);
    }
}

