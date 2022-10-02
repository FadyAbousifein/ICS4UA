/*
 * Store Project
 * Fady Abousifein ICS4UA
 */

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
    private static boolean status = true;

    public static void main(String[] args) {
        // create scanner
        Scanner scanner = new Scanner(System.in);
        // introScreen();
        // itemSelection(scanner);
        reciept(3,4,5 ,5.0);
        
    }

    // displays intro screen (and yes you don't get to choose a size)
    public static void introScreen() {
        System.out.println("Hello and welcome to Bishop Reding! What would you like to purchase today?");
        System.out.println("Long-Sleeve Shirt: $19.99\tShort-Sleeve Shirt: $18.99\t Hoodie: $29.99\n");
    }

    // prompts user input (item selection and quantity)
    public static void itemSelection(Scanner scanner) {

        try {
            System.out.print("How many Long-Sleeve shirts would you like to buy? ");
            lsQuantity = scanner.nextInt();
            System.out.print("How many Short-Sleeve shirts would you like to buy? ");
            slQuantity = scanner.nextInt();
            System.out.print("How many Hoodies would you like to buy? ");
            hQuantity = scanner.nextInt();
        }
        catch(Exception e) {
            System.out.println("Quantities can only be integers!!");
        }
    }

    // prints out reciept 
    public static void reciept(int lsQuantity, int slQuantity, int hQuantity, double total) {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("\t\tBishop Reding\n\t1120 Main St E, Milton ON L9T 6H7\n");
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
    }

    public static double total(int lsQuantity, int slQuantity, int hQuantity) {
        String total = String.format("%,.2f", (lsQuantity * LONGSLEEVE_PRICE * HST) + (slQuantity * SHORTSLEEVE_PRICE * HST) + (hQuantity * HOODIE_PRICE * HST));
        // System.out.println("Your total is: " + total);
        return Double.parseDouble(total); 
    }
}



