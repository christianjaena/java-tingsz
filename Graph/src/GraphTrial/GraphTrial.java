
package GraphTrial;

import java.util.*;

public class GraphTrial {
    int vertices;
    LinkedList<Integer>[] list;
    boolean[] isVisited;
    
    GraphTrial(int v) {
        this.vertices = v;
        list = new LinkedList[v];
        isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList();
            isVisited[i] = false;
        }
    }
    
    public void add(int s, int d) {
        list[s].add(d);
        list[d].add(s);
    }
    
    public void BFS(int s, int d) {
        Queue<Integer> queue = new LinkedList();
        Stack<Integer> stack = new Stack();
        queue.add(s);
        stack.add(s + 1);
        isVisited[s] = true;
        int source;
        while (!queue.isEmpty()) {
            boolean found = false;
            source = queue.poll();
            for (int i = 0; i < list[source].size(); i++) { 
                if (!isVisited[list[source].get(i)] && list[source].get(i) == d) {
                    stack.push(source + 1);
                    stack.push(list[source].get(i) + 1);
                    isVisited[list[source].get(i)] = true;
                }
                if (!isVisited[list[source].get(i)]) {
                    queue.add(list[source].get(i));
                    isVisited[list[source].get(i)] = true;
                }
            }
        }
        System.out.println(stack.size());
        String output = stack.toString()
        .replace("[", "")
        .replace("]", "")
        .replace(",", "");
        System.out.println(output);
       
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(input.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        GraphTrial g = new GraphTrial(N);
        for (int i = 0; i < M; i++) {
            String[] s = input.nextLine().split(" ");
            g.add(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1);
        }
        String[] s = input.nextLine().split(" ");
        g.BFS(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1);
    }

}
