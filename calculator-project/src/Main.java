/*
 * Calculator Project
 * Fady Abousifein (ICS4UA)
 */

import java.util.Scanner;
import java.util.Stack;


public class Main {

    static Stack<Double> operands = new Stack<>(); 
    static Stack<Character> operators = new Stack<>(); 

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = scanner.nextLine().replace("sqrt", "!"); 

        for(int i = 0; i < expression.length(); i++) {
            if(Character.isDigit(expression.charAt(i))) {
                String token = "";
                token = expression.substring(i).split("[^0-9.]")[0];
                
                operands.push(Double.parseDouble(token));
                
                i += token.length(); 
                i--; 
                
            } else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '^') {

                while(operators.size() > 0 && Calculator.presedenceIdentifier(operators.peek()) >= Calculator.presedenceIdentifier(expression.charAt(i))) {
                    
                    double val1 = operands.pop(); 
                    double val2 = operands.pop();
                    char operator = operators.pop();

                    double evaluationResult = Calculator.operation(val1, val2, operator);
                    operands.push(evaluationResult);
                    System.out.println(evaluationResult + " " + val1 + " " + val2 + " " + operator);
                } 
                operators.push(expression.charAt(i));
            }  
        }
         
        while(operators.size() != 0) {

                char operator = operators.pop();
                double val1 = operands.pop();
                double val2 = operands.pop();
        
                double evaluationResult = Calculator.operation(val1, val2, operator);
                operands.push(evaluationResult);
                System.out.println(evaluationResult + " " + val1 + " " + val2 + " " + operator);
        }
        System.out.println("Answer: " + operands.peek());
    }
}
