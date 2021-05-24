
package graph;

import java.util.*;

public class Graph {
    int V;
    LinkedList<Integer>[] adjList;
    Stack stack = new Stack();
    Graph(int v) {
        this.V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList();
        }
    }
    
    public void addEdge(int s, int d) {
        adjList[s].add(d + 1);
        adjList[d].add(s + 1);
    }
   
    public void findShortestPath(int x, int y) {
        for (int i = x; i < V; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                if (adjList[i].get(j) != y) {
                    stack.push(adjList[i].get(j));
                } else {
                    stack.push(adjList[i].get(j));
                    System.out.println(stack.size());
                }
            }
            
        }
        System.out.println(stack);
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        Scanner input = new Scanner(System.in);
        String s[] = input.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int T = Integer.parseInt(s[2]);
        int C = Integer.parseInt(s[3]);
        for (int i = 0; i < N; i++) {
            String t[] = input.nextLine().split(" ");
            g.addEdge(Integer.parseInt(t[0]) - 1, Integer.parseInt(t[1]) - 1);
        }
        String t[] = input.nextLine().split(" ");
        g.findShortestPath(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
        
    }

}
