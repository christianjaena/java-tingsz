import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class RPN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Double> stack = new Stack<>();
        pr.println("Input\tOperation\tStack after");
        while (st.hasMoreTokens()) {
            String input = st.nextToken();
            pr.print(input + "\t");
            switch(input) {
                case "+":
                    pr.print("Operate\t\t");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    pr.print("Operate\t\t");
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    pr.print("Operate\t\t");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    pr.print("Operate\t\t");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    pr.print("Operate\t\t");
                    double exp = stack.pop();
                    stack.push(Math.pow(stack.pop(), exp));
                    break;
                default:
                    pr.print("Push\t\t");
                    stack.push(Double.parseDouble(input));
                    break;
            }
            pr.println(stack);
        }
        pr.println("Final Answer: " + stack.pop());
        pr.flush();
        pr.close();
    } 
}
