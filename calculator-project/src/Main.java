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
                operands.push((double) expression.charAt(i) - '0');
            } else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '^' || expression.charAt(i) == '!') {

                while(operators.size() > 0 && Calculator.presedenceIdentifier(operators.peek()) >= Calculator.presedenceIdentifier(expression.charAt(i))) {
                    
                    double val1 = operands.pop(); 
                    double val2 = operands.pop();
                    char operator = operators.pop();

                    double evaluationResult = Calculator.operation(val1, val2, operator);
                    operands.push(evaluationResult);
                }
                operators.push(expression.charAt(i));
            }

        }  
        while(operators.size() != 0) {

            double val1 = operands.pop(); 
            double val2 = operands.pop();
            char operator = operators.pop();

            double evaluationResult = Calculator.operation(val1, val2, operator);
            operands.push(evaluationResult);
        }
        System.out.println("Answer: " + operands.peek());

    }
}
