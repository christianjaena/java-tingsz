import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

class JaenaExercise4B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter print = new PrintWriter(System.out);
    static String[] stringArray;
    static int N;
    static int X;
    static Queue<Spiders> queue = new LinkedList<>();
    static Queue<Spiders> queue1 = new LinkedList<>();
    
    static class Spiders {
        int power;
        int spiderIndex;
        Spiders(int power, int spiderIndex) {
            this.power = power;
            this.spiderIndex = spiderIndex;
        }
    }
    
    public void addToQueue() {
        for(int i = 0; i < N; i++) {
            queue.add(new Spiders(Integer.parseInt(stringArray[i]), i));
        }
    }
    
    public void enqueueDequeue() {
        for(int i = 0; i < X; i++){
            int temp = X;
            Spiders max = queue.poll();
            queue1.add(max);
            while(--temp != 0 && !queue.isEmpty()) {
                Spiders spider = queue.poll();
                if(spider.power > max.power) {
                    max = spider;
                }
                queue1.add(spider);
            }        
            while(!queue1.isEmpty()) {
                Spiders index = queue1.poll();
                if (index.spiderIndex == max.spiderIndex) { 
                    continue;
                }
                if (index.power > 0) {
                    index.power--;
                }
                queue.add(index);
            }
            
            print.print(max.spiderIndex + 1 + " ");
        }
        print.flush();
        print.close();
    }
    
    public static void main(String args[] ) throws Exception {
        JaenaExercise4B exe = new JaenaExercise4B();
        stringArray = br.readLine().split(" ");
        N = Integer.parseInt(stringArray[0]);
        X = Integer.parseInt(stringArray[1]);
        stringArray = br.readLine().split(" ");
        exe.addToQueue();
        exe.enqueueDequeue();
    } 
}
