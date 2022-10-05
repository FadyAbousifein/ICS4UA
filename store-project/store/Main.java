import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // calls the first two methods which call the rest of the methdos internally depending 
        // on conditional statements
        Store a = new Store();
        Scanner scanner = new Scanner(System.in);
        Store.displayIntroScreen();
        Store.itemSelection(scanner);
        scanner.close();


    }
}
