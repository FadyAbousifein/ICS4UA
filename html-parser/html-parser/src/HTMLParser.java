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
            htmlCode = new Scanner(new URL(webPageAdress).openStream()).useDelimiter("\\z").next();
            System.out.println("The title of the URL is: " + getTitle(htmlCode));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    public static String getTitle(String htmlCode)  {
        htmlCode = htmlCode.replace("\n", "").replace("\r", "");
        htmlCode = htmlCode.substring(htmlCode.indexOf("<title>") + 7);
        htmlCode = htmlCode.substring(0, htmlCode.indexOf("</"));
        String title = htmlCode.trim(); 
        return title; 
    }
}