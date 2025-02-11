import journal.reading.automation.LaunchSettings;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataFromMongoDB;
import journal.reading.automation.pageObjects.BookTitlesComponent;
import journal.reading.automation.pageObjects.HomePageObjects;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AuthorPageTests extends LaunchSettings {

    @Test
    public void assertAuthorBooks() {
        HomePageObjects homePage = new HomePageObjects(page);
        BookTitlesComponent bookTitles = new BookTitlesComponent(page);
        GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();
        DataManipulation dataManipulation = new DataManipulation();
        String expectedAuthor = "Ілларіон Павлюк";

        homePage.goToAuthorPage(expectedAuthor);
        ArrayList<String> webTitles = bookTitles.getBookTitlesOnWebSite();
        ArrayList<String> dbTitles = getDataFromMongoDB.getBookTitlesOneAuthorFromDatabase(expectedAuthor);
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles, webTitles);
    }
}
