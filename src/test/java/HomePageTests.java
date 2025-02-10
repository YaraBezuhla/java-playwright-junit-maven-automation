import journal.reading.automation.LaunchSettings;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataFromMongoDB;
import journal.reading.automation.pageObjects.BookTitlesComponent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HomePageTests extends LaunchSettings {

    @Test
    public void AssertBooks() {
        GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();
        BookTitlesComponent bookTitles = new BookTitlesComponent(page);
        DataManipulation dataManipulation = new DataManipulation();

        ArrayList<String> dbTitles = getDataFromMongoDB.getBookTitlesFromDB();
        ArrayList<String> webTitles = bookTitles.getBookTitlesOnWebSite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles, webTitles);
    }
}
