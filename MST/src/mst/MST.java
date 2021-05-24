
package mst;

import java.util.Stack;

class MST {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> stack;
    
    public MST() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        stack = new Stack();
    }
    
    public void addVertex(char label) { vertexList[nVerts++] = new Vertex(label); }
    
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }
    
    public void mst() {
        vertexList[0].wasVisited = true;
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int current = stack.peek();
            int v = getAdjUnvisitedVertex(current);
            
            if (v == -1) stack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(current);
                displayVertex(v);
                System.out.print(" ");
                stack.push(v);
            }
        }
    }
    
    public static void main(String[] args) {
       MST m = new MST();
       m.addVertex('A');
       m.addVertex('B');
       m.addVertex('C');
       m.addVertex('D');
       m.addVertex('E');
       
       m.addEdge(0, 1);
       m.addEdge(0, 2);
       m.addEdge(0, 3);
       m.addEdge(0, 4);
       m.addEdge(1, 2);
       m.addEdge(1, 3);
       m.addEdge(1, 4);
       m.addEdge(2, 3);
       m.addEdge(2, 4);
       m.addEdge(3, 4);
       
        System.out.println("MST: ");
        m.mst();
    }

}

class Vertex {
    public char label;
    public boolean wasVisited;
    
    public Vertex(char lab) {
        label= lab;
        wasVisited = false;
    }
}

