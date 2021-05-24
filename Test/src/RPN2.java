


import java.util.*;

public class RPN2 {
    
    public static void compute(String expr) throws Exception  {
        Stack<Double> stack = new Stack<>();
        System.out.println(expr);
        System.out.println("Input\t Operation\tStack after");
        
        for (String token : expr.split("\\s+")) {
            System.out.print(token + "\t");
            switch (token) {
                case "+":
                    System.out.print("Operate\t\t");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    System.out.print("Operate\t\t");
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    System.out.print("Operate\t\t");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    System.out.print("Operate\t\t");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    System.out.print("Operate\t\t");
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                default:
                    System.out.print("Push\t\t");
                    stack.push(Double.parseDouble(token));
                    break;
            }
            System.out.println(stack);
        }
        System.out.println("Final Answer: " + stack.pop());
    }
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String scan = input.nextLine();
        try {
            compute(scan);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
  
