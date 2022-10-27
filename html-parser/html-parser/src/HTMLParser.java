/*
 * HTMLParser
 * Fady Abousfein (ICS4UA)
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTMLParser {
    public static void main(String[] args) {
        
        // variable declarations
        String htmlCode = ""; 
        String webPageAdress = "https://www.wyoarea.org"; 
        String title = ""; 

        // prompt the user to input a web url and get that address from user
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter a full web page address (URL) and press the enter key: ");
        webPageAdress = scanner.nextLine(); 

        // retreive the HTML code from url - /z marks the end of a file
        try {
            htmlCode = new Scanner(new URL(webPageAdress).openStream()).useDelimiter("\\Z").next();
            System.out.println("The title of the URL is: " + getTitle(htmlCode));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        scanner.close(); 
    }

    // puts the entire html code onto one line then creates a substring starting from the <title>
    // then we create a substring of that substring to close the </title> giving us the title
    public static String getTitle(String htmlCode)  {
        return htmlCode.split("<title>")[1].split("</title>")[0].trim();
    }
}