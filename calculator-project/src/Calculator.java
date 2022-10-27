import java.util.Stack;

public class Calculator {

    // bedmass implementation (order of operations)
    public static int presedenceIdentifier(char operator) {
        
        switch(operator) {
            case '+':
            case '-':
                return 1; 
            case '*':
            case '/': 
                return 2; 
            case '^': 
            case '!': 
                return 3;
        }
        return 0; // doesn't do anything
    }

    // arithmetic operation logic
    public static double operation(double val1, double val2, char operator) {

        switch(operator) {
            case '+':
                return val1 + val2; 
            case '-':
                return val1 - val2; 
            case '*':
                return val1 * val2; 
            case '/': 
                return val1 / val2; 
            case '^': 
                return Math.pow(val1, val2); 
            case '!': 
                return Math.sqrt(val2);
        }
        return 0; 

    }

}
