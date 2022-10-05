/*
 * Store Project (ICS4UA)
 * Fady Abousifein 
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner; 

 public class Store {

    private static final double HST = 1.13; 
    private static int apQuantity;
    private static boolean SAT; 
    private static boolean ACT;
    private static boolean quit; 


    // displays intro screen 
    public static void displayIntroScreen() {
        System.out.println("\nWelcome to CollegeBoard the \"non-profit organization\" what would you like to purchase?\n");
        System.out.println("\tAP Exam: $205.00\tSAT: $135\tACT: $100\n");
    }

    // promts the user to select quantity of products they would like to purchase
    public static void itemSelection(Scanner scanner) {
        System.out.print("Would you like to write an AP Exam? (Y/N): ");
        String input1 = scanner.next().toUpperCase();
        int input2;

        if(input1.equals("Y")) {
            System.out.print("How many AP exams would you like to write: ");
            input2 = scanner.nextInt(); 
        } else {
            input2 = 0; 
        }

        System.out.print("Would you like to write the SAT: ");
        String input3 = scanner.next().toUpperCase(); 
        if(input3.equals("Y")) {
            SAT = true; 
        }

        System.out.print("Would you like to write the ACT: ");
        String input4 = scanner.next().toUpperCase(); 
        if(input4.equals("Y")) {
            ACT = true;
        }

        int shoppingListSAT = 0;
        int shoppingListACT = 0;

        if(SAT) {
            shoppingListSAT = 1; 
        } 

        if(ACT) {
            shoppingListACT = 1; 
        } 

        System.out.println("\nHere is your shopping list:\n\n" + "ACT: "+ shoppingListACT + "\tSAT: " + shoppingListSAT + "\tAP Exams: " + input2 + "\n");
        System.out.print("Would you like to check out? ");
        String checkOut = scanner.next().toUpperCase();
        if(checkOut.equals("Y")) {
            checkout(input2, shoppingListSAT, shoppingListACT, scanner);
        } else {
            System.out.print("Would you like to quit? ");
            String quitIn = scanner.next().toUpperCase(); 
            if(quitIn.equals("Y")) {
                quit = true; 
                quit(quit);
            } else {
                checkout(input2, shoppingListACT, shoppingListACT, scanner);
            }
        }
    }

    // quit method
    public static void quit(boolean quit) {
        if(quit == true) {
            System.out.print("\033[H\033[2J");  
        }
    }

    // calculates subtotal and checks out
    public static void checkout(int apQuantity, int SAT, int ACT, Scanner scanner) {
        if(SAT == 1) {
            SAT = 135; 
        }
        if(ACT == 1) {
            ACT = 100;
        }

        double subTotal = (apQuantity * 205) + (SAT) + (ACT);
        String sTotal = String.format("%,.2f", subTotal);
        System.out.print("Your subtotal is: $" + sTotal + " Would you like to pay or purchase another exam? (pay/exam) ");
        String anotherExam = scanner.next().toUpperCase(); 
        if(anotherExam.equals("EXAM")) {
            System.out.print("How many more AP exams would you like to write? ");
            int extraExams = scanner.nextInt(); 
            reciept(subTotal, extraExams);
        
        } else {
           reciept(subTotal);
        }

    }

    // displays reciept if you didn't write extra exams
    public static void reciept(double subTotal) {

        int random = (int)(Math.random() * 100) + 1; 
        if(random == 1) {
            System.out.println("How did you win everything for free it was a one in 100 chance... congratulations I guess");
        } else {
            Calendar calendar = Calendar.getInstance(); 
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
            double total = subTotal * HST;
            String fTotal = String.format("%,.2f", total);
            System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("\t\tCollegeBoard\n    4200 Farm Hill Blvd Redwood City, CA 94061\n\t     " + formatter.format(calendar.getTime()));
            System.out.print("------------------------------------------------\n");
            System.out.println("Total: $" + fTotal);
            System.out.println("Thanks for shopping at CollegeBoard your favourite \n\"non-profit orgaization\"!\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(" _____     _ _                _____               _"); 
            System.out.println("|     |___| | |___ ___ ___   | __  |___ ___ ___ _| |"); 
            System.out.println("|   --| . | | | -_| . | -_|  | __ -| . | .'|  _| . |");
            System.out.println("|_____|___|_|_|___|_  |___|  |_____|___|__,|_| |___|");
            System.out.println("                  |___|                             ");
        }  
    }
    
    // displays reciept if you did write extra exams
    public static void reciept(double subTotal, int extraExams) {

        int random = (int)(Math.random() * 100) + 1; 
        if(random == 1) {
            System.out.println("How did you win everything for free it was a one in 100 chance... congratulations I guess");
        } else {
            double newSubTotal = subTotal + (extraExams * 205);
            String newSTotal = String.format("%,.2f", newSubTotal);
            System.out.println("\nYour new subtotal is: $" + newSTotal);
            Calendar calendar = Calendar.getInstance(); 
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
            double total = newSubTotal * HST;
            String fTotal = String.format("%,.2f", total);
            System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("\t\tCollegeBoard\n    4200 Farm Hill Blvd Redwood City, CA 94061\n\t     " + formatter.format(calendar.getTime()));
            System.out.print("------------------------------------------------\n");
            System.out.println("Total: $" + fTotal);
            System.out.println("Thanks for shopping at CollegeBoard your favourite \n\"non-profit orgaization\"!\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(" _____     _ _                _____               _"); 
            System.out.println("|     |___| | |___ ___ ___   | __  |___ ___ ___ _| |"); 
            System.out.println("|   --| . | | | -_| . | -_|  | __ -| . | .'|  _| . |");
            System.out.println("|_____|___|_|_|___|_  |___|  |_____|___|__,|_| |___|");
            System.out.println("                  |___|                             ");
        }
    }

 }
