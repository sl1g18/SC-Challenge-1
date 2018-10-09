import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PageHandler {

    public String getName(String user){
        Document doc = fetchWebPageFromUser(user);

        Elements name = doc.select("[property=name]");
        return name.first().text();
    }

    public Document fetchWebPageFromUser(String user){
        String pgURL;
        pgURL = "https://www.ecs.soton.ac.uk/people/" + user;
        Document doc = null;

        try {
            doc = Jsoup.connect(pgURL).get();
        } catch (IOException e) {
            System.out.println("Page does not exist!");
        }

        return doc;
    }
}
