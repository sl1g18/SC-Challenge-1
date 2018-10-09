/*
* Used Jsoup, an open-source HTML parser for Java (https://jsoup.org/cookbook/)
*
*/

import java.util.Scanner;

public class MainInterface {
    public String readUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your username?");
        String user = scanner.nextLine();
        return user;
    }

    public static void main(String[] args) {
        MainInterface userInt = new MainInterface();
        PageHandler page = new PageHandler();
        String resultName;

        resultName = page.getName(userInt.readUsername());
        System.out.println("The name you're looking for is "+resultName);
    }
}
