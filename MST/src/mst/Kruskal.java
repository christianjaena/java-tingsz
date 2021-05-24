
package mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {
    
    static class Edge {
        int source;
        int destination;
        int weight;
        
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        } 
    }
    
    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();
        
        Graph(int vertices) {
            this.vertices = vertices;
        }
        
        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }
        
        public void kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
            // add edges to prio queue, sort increasing by weight
            for (int i = 0; i < allEdges.size(); i++) {
                pq.add(allEdges.get(i));
            }
            
            int[] parent = new int[vertices];
            
            // makeset
            makeSet(parent);
            
            ArrayList<Edge> mst = new ArrayList<>();
            
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                // check cycle
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);
                
                if (x_set == y_set) {
                    // ignore, will create cycle
                } else {
                    // add to final result
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            // print MST
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }
        
        public void makeSet(int[] parent) {
            // makeSet - creating a new element with a parent pointer to itself
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int[] parent, int vertex) {
            // chain of parent pointers from x upwards through the tree
            // until an element is reached whose parent is itself
            if (parent[vertex] != vertex) {
                return find(parent, parent[vertex]);
            }
            return vertex;
        }
        
        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            // make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }
        
        public void printGraph(ArrayList<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        "weight: " + edge.weight);
            }
        }
    }
    public static void main(String[] args) {
       // put vertices and weight(edges) to an array
       // sort the array ascending by weight
       // add edge with least weight
       // check if it creates a cycle
            //if cycle: discard
       // repeat until V-1
       int vertices = 6;
       Graph graph = new Graph(vertices);
       graph.addEdge(0, 1, 4);
       graph.addEdge(0, 2, 3);
       graph.addEdge(1, 2, 1);
       graph.addEdge(1, 3, 2);
       graph.addEdge(2, 3, 4);
       graph.addEdge(3, 4, 2);
       graph.addEdge(4, 5, 6);
       graph.kruskalMST();
    }
}
