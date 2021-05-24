
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class TRY {
    static boolean deleteFriend = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int deleteCount = 0;
            for (int j = 0;st.hasMoreTokens(); j++) {
                stack.push(Integer.parseInt(st.nextToken()));
                if (stack.size() > 1 && deleteCount < K) {
                    for (int k = 0; k < stack.size() - 1; k++) {
                        if (stack.get(k) < stack.get(k + 1)) {
                            stack.remove(k);
                            deleteCount++;
                            deleteFriend = true;
                            break;
                        }
                        if (!deleteFriend) {
                            stack.pop();
                            deleteCount++;
                        }
                    }
                }
            }
            sb.append(stack.toString().replace(",","").replace("[", "").replace("]", ""));
            sb.append("\n");
            if (deleteCount == K) {
                stack.clear();
            }       
        }
        pr.print(sb); 
        pr.flush();
        pr.close();
    }
}
