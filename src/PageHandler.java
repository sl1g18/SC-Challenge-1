import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PageHandler {

    public String getName(String user){  // This method looks for the name of the person with the userid 'user'
        Document doc = fetchWebPageFromUser(user); // Creating a JSoup document from the user's page

        Elements name = doc.select("[property=name]"); // Looking for the '[property=name]' in the extracted page
        return name.first().text(); // The 'name' element includes the entire HTML code of the line that contains the name, but we only return the actual name or .text
    }

    public Document fetchWebPageFromUser(String user){ // This method uses the JSoup library in order to connect to the web page and fetch a parsed copy of it
        String pgURL;
        pgURL = "https://www.ecs.soton.ac.uk/people/" + user; // Concatenating the username with the general URL in order to create the needed personal page URL
        Document doc = null;

        try {
            doc = Jsoup.connect(pgURL).get(); // Fetch parse the required page
        } catch (IOException e) { // If the method returns an error, we need to catch that and let the user know
            System.out.println("The connection to the page failed."); // Let the user know something's not right
        }

        return doc; // Returned the fetched document so that we can process it in the getName method and get the final answer.
    }
}
