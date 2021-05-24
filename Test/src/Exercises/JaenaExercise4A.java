import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;
class JaenaExercise4A {
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter = new PrintWriter(System.out);
    static StringTokenizer st;
    static Stack<Integer> stack =new Stack<>();
    static long A[];
    static int sum[];
    static int N;
    
    public static void getN() throws Exception {
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        sum = new int[N]; 
    }
    
    public void getX() {
        for(int i = 0; i < N; i++){
            long temp = Long.parseLong(st.nextToken());
            A[i] = temp;
            while (!stack.isEmpty() && A[stack.peek()] <= temp){
                stack.pop();
            }
            if (stack.isEmpty()){
                sum[i]= -1;
            } else {
                sum[i]=stack.peek() + 1;
            }
            stack.push(i);
        }
    }
    
    public void getY() {
        for (int i= N - 1; i >= 0; i--){
            long temp=A[i];
            while(!stack.isEmpty() && A[stack.peek()] <= temp){
                stack.pop();
            }
            if(stack.isEmpty()){
                sum[i] -= 1;
            } else {
                sum[i] += stack.peek() + 1;
            }
            stack.push(i);
        }
    }
    
    public void print() {
        for(int i=0; i<N; i++){
            printWriter.print(sum[i]+" ");   
        }
        printWriter.flush();
        printWriter.close();
    }
    
    public static void main(String[] args) throws Exception {
        JaenaExercise4A exe = new JaenaExercise4A();
        getN();
        st = new StringTokenizer(br.readLine());
        exe.getX();
        stack =new Stack<>();
        exe.getY();
        exe.print();
    }
}
