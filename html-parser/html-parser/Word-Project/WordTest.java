/*
 * WordProject Assignment 
 * Fady Abousifein (ICS4UA)
 */

import java.util.Scanner;

public class WordTest {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String wordInput = scanner.next(); 

        Word word1 = new Word(wordInput); 

        // displays word, first letter of word, and last letter of word
        System.out.println("The word you entered is: " + word1.getWord());
        System.out.println("The first letter of your word is: " + word1.getFirstLetter());
        System.out.println("The last letter of your word is: " + word1.getLastLetter());

        // removes first letter from string and displays the "new" string
        word1.removeFirstLetter(wordInput);
        System.out.println("Your word without the first letter is: " + word1.getWord());

        // removes last letter from string and displays the "new" string
        word1.removeLastLetter(wordInput);
        System.out.println("Your word without the last letter is: " + word1.getWord());

        // prompts the user for a letter and return the index of that letter if 
        // it is found in their word or return -1 if letter is not found
        System.out.print("What letter would you like to find: ");
        String letterInput = scanner.next();
        System.out.println("The letter is located in index " + word1.findLetter(letterInput, wordInput) + " of your word");


    }

}
