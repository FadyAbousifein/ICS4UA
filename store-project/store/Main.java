/*
 * Store Project
 * Fady Abousifein ICS4UA
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // instance variables
    private static final double HST = 1.13; 
    private static final double LONGSLEEVE_PRICE = 19.99;
    private static final double SHORTSLEEVE_PRICE = 18.99; 
    private static final double HOODIE_PRICE = 29.99; 
    private static int lsQuantity; 
    private static int slQuantity; 
    private static int hQuantity; 

    public static void main(String[] args) throws Exception {
        // create scanner
        Scanner scanner = new Scanner(System.in);

        while(true) {
            introScreen();
            // if this method throws an exception we will break entirely
            if(itemSelection(scanner)) {
                break; 
            }
            // if this method returns true (as in the transaction is complete) we will exit the program
            if(reciept(lsQuantity, slQuantity, hQuantity , total(lsQuantity, slQuantity, hQuantity))) {
                break; 
            }
        }
    }

    // displays intro screen (and yes you don't get to choose a size)
    public static void introScreen() {
        System.out.println("\nHello and welcome to Bishop Reding! What would you like to purchase today?");
        System.out.println("Long-Sleeve Shirt: $19.99\tShort-Sleeve Shirt: $18.99\t Hoodie: $29.99\n");
    }

    // prompts user input (item selection and quantity)
    public static boolean itemSelection(Scanner scanner) throws Exception {

        // will catch any exception (most likely an input data type mismatch)
        // also prevents user from getting away with inputing a negative quantity
        try {
            System.out.print("How many Long-Sleeve shirts would you like to buy? ");
            lsQuantity = scanner.nextInt();
            System.out.print("How many Short-Sleeve shirts would you like to buy? ");
            slQuantity = scanner.nextInt();
            System.out.print("How many Hoodies would you like to buy? ");
            hQuantity = scanner.nextInt();
            if(lsQuantity > 0 || slQuantity > 0 || hQuantity > 0) {
                throw new Exception(); 
            }
            return false;
        }
        catch(InputMismatchException e) {
            System.out.println("You are not built like that lol");
            return true;
        } catch (Exception e) {
            System.out.println("Quantities can only be positive integers!! Come back when your less stupid");
            return true; 
        }
    }

    // prints out reciept 
    public static boolean reciept(int lsQuantity, int slQuantity, int hQuantity, double total) {

        // on the house lotery system 
        int random = (int) (Math.random() * 11); 
        if(random == 3) {
            total = 0; 

            if(total == 0) {
                // TODO: just make another method to print out the reciept and one for the lottery system
                Calendar calendar = Calendar.getInstance(); 
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("\t\tBishop Reding\n\t1120 Main St E, Milton ON L9T 6H7\n\t     " + formatter.format(calendar.getTime()));
                System.out.print("------------------------------------------------\n");
                System.out.println("Long-Sleeve Shirt: " + lsQuantity + "\n" + "Short-Sleeve Shirt: " + slQuantity + "\n" + "Hoodie: " + hQuantity);
                System.out.println("Total: " + total + "! Congratulations for winning Bishop\nRedings' on the house award!");
                System.out.println("Thanks for shopping at BishopReding!\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println(" ____  _     _                   _____          _ _ "); 
                System.out.println("|  _ \\(_)   | |                 |  __ \\        | (_)"); 
                System.out.println("| |_) |_ ___| |__   ___  _ __   | |__) |___  __| |_ _ __   __ _");
                System.out.println("|  _ <| / __| '_ \\ / _ \\| '_ \\  |  _  // _ \\/ _` | | '_ \\ / _` |");
                System.out.println("| |_) | \\__ \\ | | | (_) | |_) | | | \\ \\  __/ (_| | | | | | (_| |");
                System.out.println("|____/|_|___/_| |_|\\___/| .__/  |_|  \\_\\___|\\__,_|_|_| |_|\\__, |");
                System.out.println("                        | |                                __/ |");
                System.out.println("                        |_|                               |___/");
                return true; 
            }
        }

        // normal reciept if you do not win the on the house lottery
        Calendar calendar = Calendar.getInstance(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("\t\tBishop Reding\n\t1120 Main St E, Milton ON L9T 6H7\n\t     " + formatter.format(calendar.getTime()));
        System.out.print("------------------------------------------------\n");
        System.out.println("Long-Sleeve Shirt: " + lsQuantity + "\n" + "Short-Sleeve Shirt: " + slQuantity + "\n" + "Hoodie: " + hQuantity);
        System.out.println("Total: " + total);
        System.out.println("Thanks for shopping at BishopReding!\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(" ____  _     _                   _____          _ _ "); 
        System.out.println("|  _ \\(_)   | |                 |  __ \\        | (_)"); 
        System.out.println("| |_) |_ ___| |__   ___  _ __   | |__) |___  __| |_ _ __   __ _");
        System.out.println("|  _ <| / __| '_ \\ / _ \\| '_ \\  |  _  // _ \\/ _` | | '_ \\ / _` |");
        System.out.println("| |_) | \\__ \\ | | | (_) | |_) | | | \\ \\  __/ (_| | | | | | (_| |");
        System.out.println("|____/|_|___/_| |_|\\___/| .__/  |_|  \\_\\___|\\__,_|_|_| |_|\\__, |");
        System.out.println("                        | |                                __/ |");
        System.out.println("                        |_|                               |___/");
        return true; 
    }

    // calculates total and returns it
    public static double total(int lsQuantity, int slQuantity, int hQuantity) {
        String total = String.format("%,.2f", ((lsQuantity * LONGSLEEVE_PRICE ) + (slQuantity * SHORTSLEEVE_PRICE) + (hQuantity * HOODIE_PRICE)) * HST);
        // System.out.println("Your total is: " + total);
        return Double.parseDouble(total); 
    }
}