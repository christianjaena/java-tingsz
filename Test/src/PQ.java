import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(15);
        pq.add(20);
        pq.add(17);
        pq.add(25);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
    }
}
