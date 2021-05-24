


import java.util.Stack;

public class Test {
    // Higher returned value, higher precedence.
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack  = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            // If the scanned character is an operand, add to the output.
            if (Character.isLetterOrDigit(c)) result += c;       
            // If the scanned character is an '(', push to the stack.
            else if (c == '(') stack.push(c);                
            /* If the scanned character is an ')', pop and output from the stack.
             * until an '(' is encountered.
             */
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                    if (!stack.isEmpty() && stack.peek() != '(') return "Invalid Expression";     
                    else stack.pop();        
                }
            } else {
                // An operand is encountered.
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek() == '(') return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }
    
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
    
}
