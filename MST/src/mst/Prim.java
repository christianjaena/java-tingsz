
package mst;


public class Prim {
    
    static class Graph {
        int vertices;
        int[][] matrix;
        int C;
        
        public Graph (int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }
        
        public void addEdge(int source, int destination, int weight) {
            matrix[source][destination] = weight;
            matrix[destination][source] = weight;
        }
        
        // get the vertex with minimum key which is not in MST
        int getMinVertex(boolean[] mst, int[] key) {
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i < vertices; i++) {
                if (mst[i] == false && minKey > key[i]) {
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }
        
        class ResultSet {
            // will store the vertex(parent) from which the current vertex will reach
            int parent;
            // will store the weight for printing the MST weight
            int weight;
        }
        
        public void primMST() {
            boolean[] mst = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            int[] key = new int[vertices];
            // initialize all keys to infinity
            // initialize resultSet for all vertices
            for (int i = 0; i < vertices; i++) {
                key[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
            }
            
            // start from the vertex 0
            key[0] = 0;
            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;
            
            // create MST
            for (int i = 0; i < vertices; i++) {
                //get the min key vertex
                int vertex = getMinVertex(mst, key);
                // include vertex in MST
                mst[vertex] = true;
                
                // iterate through all adjacent vertices  of above vertex and update keys
                for (int j = 0; j < vertices; j++) {
                    // check
                    if (matrix[vertex][j] > 0) {
                        // check if vertex 'j' is already in mst
                        // if no then check if key needs updated
                        if (mst[j] == false && matrix[vertex][j] < key[j]) {
                            // update the key
                            key[j] = matrix[vertex][j];
                            // update the result set
                            resultSet[j].parent = vertex;
                            resultSet[j].weight = key[j];
                        }
                    }
                }
            }  
            printMST(resultSet);
        }
        
        public void printMST(ResultSet[] resultSet) {
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                        " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            if (total_min_weight != C) total_min_weight = -1;
            System.out.println("Total minimum key: " + total_min_weight);
        }
    }
    
    public static void main(String[] args) {
        int vertices = 3;
        Graph graph = new Graph(vertices);
        graph.C = 25;
        
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 0, 30);
        graph.primMST();
    }
}
