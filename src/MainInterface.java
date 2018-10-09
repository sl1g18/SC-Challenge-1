/*
* Used Jsoup, an open-source HTML parser for Java (https://jsoup.org/cookbook/)
*/

import java.util.Scanner;

public class MainInterface { //This class will be used for methods required to interface with the users
    public String readUsername(){ // This method uses a scanner to read an username from the console
        Scanner scanner = new Scanner(System.in); // Creating a scanner object in order to scan the console for inputs
        System.out.println("What is your username?"); // Prompting the user to input an username
        String user = scanner.nextLine(); // Reading whatever the user inputs in the next line in the console and storing it as the username
        return user; // Returning the read username for further use
    }

    public static void main(String[] args) {
        MainInterface userInt = new MainInterface(); // Creating a new instance of the MainInterface class in order to use the readUsername method.
        PageHandler page = new PageHandler(); // Creating a new instance of the PageHandler class in order to process the page and get the name linked to typed username
        String resultName,user;
        user = userInt.readUsername(); // Calling the method readUsername for the MainInterface object created earlier in order to get the username from the console
        resultName = page.getName(user); // Passing the username to the Page Handler class in order to extract the name
        System.out.println("The name you're looking for is "+resultName); // Print out the result in the console
    }
}
