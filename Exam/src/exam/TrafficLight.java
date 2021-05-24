
package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TrafficLight {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        LinkedList<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int signal = 0;
        int second = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            char C = st.nextToken().charAt(0);
            int state = (C == 'R') ? 1 : (C == 'Y') ? 2 : (C == 'G') ? 3 : -1;
            int light;
            if (queue.size() < K) {
                light = (state + signal) % 3;
                light = (light == 0) ? 0 : 3 - light;
            } else {
                signal = signal - queue.poll();
                light = (state + signal) % 3;
                light = (light == 0) ? 0 : 3 - light;
            }
            signal = signal + light;
            second = second + light;
            queue.add(light);
        }
        pw.println(second);
        pw.flush();
        pw.close();
    }
}
