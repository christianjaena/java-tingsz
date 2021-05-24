
package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class BalancedParenthesis {
    static PrintWriter pw = new PrintWriter(System.out);
    
    public String isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.isEmpty()) stack.push(charArray[i]); 
            else if (charArray[i] == '}') {
                if (stack.lastElement() == '{') stack.pop();  
                else return "NO";
            } else if (charArray[i] == ']') {
                if (stack.lastElement() == '[') stack.pop();
                else  return "NO";
            } else if (charArray[i] == ')') {
                if (stack.lastElement() == '(') stack.pop();
                else return "NO";
            } else stack.push(charArray[i]); 
        }
        if (stack.isEmpty()) return "YES";
        return "NO";
    }    

    public static void main(String[] args) throws Exception {
        BalancedParenthesis e = new BalancedParenthesis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String braces = br.readLine();
            pw.println(e.isBalanced(braces));      
        }
        pw.flush();
        pw.close();
    }    
}
