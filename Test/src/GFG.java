


import java.util.*;

public class GFG {
    
    static boolean isOperand(char x) { return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'); }
    
    // Get Infix for a given Postfix expression.
    static String getInfix(String exp) {
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < exp.length(); i++) {
            // Push Operands
            if (isOperand(exp.charAt(i))) s.push(exp.charAt(i) + "");
            else {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) + op1 + ")");
            }
        }
        return s.peek();
    }
    
    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println(getInfix(exp));
    }
}
