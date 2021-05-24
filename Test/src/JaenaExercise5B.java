
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JaenaExercise5B {
     
   
    static boolean deleteFriend = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer st;
        ArrayList<Long> al = new ArrayList<Long>();
        JaenaExercise5B exe = new JaenaExercise5B();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
               al.add(Long.parseLong(st.nextToken()));
            }
            for (int k = 0; k < K; k++) {
                for (int j = 0; j < al.size() - 1; j++) { 
                    if (al.get(j) < al.get(j + 1)) {
                        al.remove(j);
                        deleteFriend = true;
                        break;
                    }
                    if (!deleteFriend) {
                        al.remove(al.size() - 1);
                    }      
                }
            } 
            for (int j = 0; j < al.size(); j++) {
                pr.print(al.get(j) + " ");     
            }
            pr.print("\n");   
            al.clear();
        }
        pr.flush();
        pr.close();
    }
}
