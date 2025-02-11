import io.qameta.allure.Description;
import journal.reading.automation.LaunchSettings;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataFromMongoDB;
import journal.reading.automation.pageObjects.BookTitlesComponent;
import journal.reading.automation.pageObjects.HomePageObjects;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HomePageTests extends LaunchSettings {

    @Test
    @Description("Порівняння книг, що є в базі і що виводяться на сайті по тайтлу")
    public void AssertBooks() {
        GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();
        BookTitlesComponent bookTitles = new BookTitlesComponent(page);
        DataManipulation dataManipulation = new DataManipulation();

        ArrayList<String> dbTitles = getDataFromMongoDB.getBookTitlesFromDB();
        ArrayList<String> webTitles = bookTitles.getBookTitlesOnWebSite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles, webTitles);
    }

    @Test
    @Description("Перевірка назв блоків на головній сторінці")
    public void AssertBlockTitles() {
        HomePageObjects homePage = new HomePageObjects(page);
        homePage.assertBlocksName("Найпопулярніші книги", "Українські автори");
    }
}
